package io.coral.contacts.model.repository.impl

import io.coral.contacts.model.domain.Organization
import io.coral.contacts.model.domain.TPAInfo
import io.coral.contacts.model.exception.ContactsDefaultException
import io.coral.contacts.model.exception.ObjectNotFoundException
import io.coral.contacts.model.mapper.BasicModelMapper
import io.coral.contacts.model.mapper.ContactModelMapper
import io.coral.contacts.model.repository.OrganizationRepository
import java.util.stream.Collectors
import javax.persistence.EntityManager

class OrganizationRepositoryImpl : OrganizationRepository, ContactRepositoryImpl() {

    override fun add(organization: Organization): Organization {
        try {
            if (organization.TPA) {
                organization.tpaInfo = TPAInfo()
            }
            ContactModelMapper().updateEntity(organization)
            return doAdd(organization) as Organization
        } catch (ex: Exception) {
            throw ContactsDefaultException(ex)
        }
    }



    override fun getById(id: Int): Organization {
        try {
            return entityManager.find(Organization::class.java, id) ?:throw ObjectNotFoundException()
        } catch (ex: Exception) {
            throw ContactsDefaultException(ex)
        } finally {
            entityManager.close()
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
            em.merge(organizationEntity)
            em.transaction.commit()
            return em.find(Organization::class.java, organization.id)
        } catch (ex: Exception) {
            throw ContactsDefaultException(ex)
        } finally {
            em!!.close()
        }

    }




}