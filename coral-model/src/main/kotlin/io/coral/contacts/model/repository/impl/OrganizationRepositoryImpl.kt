package io.coral.contacts.model.repository.impl

import io.coral.contacts.model.domain.Location
import io.coral.contacts.model.domain.Organization
import io.coral.contacts.model.domain.TPAInfo
import io.coral.contacts.model.exception.ContactConflictException
import io.coral.contacts.model.exception.ContactsDefaultException
import io.coral.contacts.model.exception.ObjectNotFoundException
import io.coral.contacts.model.mapper.BasicModelMapper
import io.coral.contacts.model.mapper.ContactModelMapper
import io.coral.contacts.model.repository.OrganizationRepository
import java.util.stream.Collectors
import javax.persistence.EntityManager

class OrganizationRepositoryImpl : OrganizationRepository, ContactRepositoryImpl() {

    override fun add(organization: Organization): Organization {
        var em: EntityManager? = null
        try {
            em = entityManager
            em.transaction.begin()
            // check if provider npi is exist
            if(organization.providerInfo!=null){
                val npi= organization.providerInfo!!.npi
                val count=(em.createNamedQuery("HealthcareProviderInfo.getByNpi").setParameter("npi",npi).singleResult as Long).toInt()
                if (count>0){
                    throw ContactConflictException("npi with value $npi already exist ")
                }
            }
            if (organization.tpaInfo!=null) {
                organization.tpaInfo = TPAInfo()
            }
            ContactModelMapper().updateEntity(organization)
            var tempPrimaryLocation:Location?=null
            if(organization.primaryLocation!=null){
                organization.locations.forEach {
                    if (it==(organization.primaryLocation)){
                        tempPrimaryLocation=it; organization.primaryLocation=null
                    }
                }
            }
            em.persist(organization)
            if(tempPrimaryLocation!=null){
                organization.primaryLocation=tempPrimaryLocation
            }
            em.transaction.commit()
            return organization
        } catch (e:ContactConflictException){
            throw e
        } catch (ex: Exception) {
            throw ContactsDefaultException(ex)
        }finally {
            em!!.close()
        }
    }



    override fun getById(id: Int): Organization {
        var em: EntityManager? = null
        try {
            em = entityManager
            return em.find(Organization::class.java, id) ?:throw ObjectNotFoundException()
        } catch (ex: Exception) {
            throw ContactsDefaultException(ex)
        } finally {
            em!!.close()
        }
    }

    override fun update(organization:Organization):Organization{
        var em: EntityManager? = null
        try {
            em = entityManager
            em.transaction.begin()
            var organizationEntity = em.find(Organization::class.java, organization.id) ?: throw ObjectNotFoundException()
            // Start remove un used locations
            val allLocationsDtoId: MutableList<Int> =
                organization.locations.stream().filter { it.id != null }.map { it.id }.collect(Collectors.toList())
            organizationEntity.locations.forEach {
                if (!allLocationsDtoId.contains(it.id)) {
                    em.remove(it)
                }
            }
            // end remove un used locations
            organizationEntity = BasicModelMapper.convertTo(organization, Organization()) as Organization
            ContactModelMapper().updateEntity(organizationEntity)
            var tempPrimaryLocation:Location?=null
            if(organization.primaryLocation!=null){
                organization.locations.forEach {
                    if (it==(organization.primaryLocation)){
                        tempPrimaryLocation=it; organization.primaryLocation=null
                    }
                }
            }
            em.merge(organizationEntity)
            if(tempPrimaryLocation!=null){
                organizationEntity.primaryLocation=tempPrimaryLocation
                em.merge(organizationEntity)
            }
            em.transaction.commit()
            return em.find(Organization::class.java, organization.id)
        } catch (ex: Exception) {
            throw ContactsDefaultException(ex)
        } finally {
            em!!.close()
        }

    }




}