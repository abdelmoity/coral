package io.coral.contacts.model.repository.impl

import io.coral.contacts.model.domain.Contact
import io.coral.contacts.model.domain.Organization
import io.coral.contacts.model.dto.OrganizationDto
import io.coral.contacts.model.exception.ContactsDefaultException
import io.coral.contacts.model.exception.ObjectNotFoundException
import io.coral.contacts.model.mapper.BasicModelMapper
import io.coral.contacts.model.repository.OrganizationRepository
import io.tech4health.ts.model.domain.AbstractEntity
import java.util.stream.Collectors
import javax.persistence.EntityManager

class OrganizationRepositoryImpl : OrganizationRepository, ContactRepositoryImpl() {

    override fun add(dto: OrganizationDto): OrganizationDto {
        try {
            var organization: Organization = BasicModelMapper.convertTo(dto, Organization()) as Organization
            updateOrganizationRelationData(organization)
            organization = doAdd(organization) as Organization
            return BasicModelMapper.convertTo(organization, OrganizationDto()) as OrganizationDto
        }catch (ex:Exception){
            throw ContactsDefaultException(ex)
        }
    }

    override fun getById(id: Int): OrganizationDto {
        try {
            val entity = entityManager.find(Organization::class.java, id) ?:throw ObjectNotFoundException()
            return BasicModelMapper.convertTo(entity, OrganizationDto()) as OrganizationDto
        } catch (ex: Exception) {
            throw ContactsDefaultException(ex)
        } finally {
            entityManager.close()
        }
    }

    override fun update(dto:OrganizationDto):OrganizationDto{
        var em: EntityManager? = null
        try {
            em=entityManager
            em.transaction.begin()
            var organization=em.find(Organization::class.java,dto.id) ?: throw ObjectNotFoundException()
            // Start remove un used locations
            val allLocationsDtoId: MutableList<Int> = dto.locations.stream().filter { it.id != null }.map { it.id }.collect(Collectors.toList())
            organization.locations.forEach {
                if (!allLocationsDtoId.contains(it.id)) {
                    em.remove(it)
                }
            }
            // end remove un used locations
            organization = BasicModelMapper.convertTo(dto,Organization()) as Organization
            updateOrganizationRelationData(organization)
            em.merge(organization)
            em.transaction.commit()
            return BasicModelMapper.convertTo(organization, OrganizationDto()) as OrganizationDto
        } catch (ex: Exception) {
            throw ContactsDefaultException(ex)
        } finally {
            em!!.close()
        }

    }

    private fun updateOrganizationRelationData(organization:Organization){
        organization.locations.forEach { it.contact = organization }
        if(organization.tpaInfo!=null){
            organization.tpaInfo!!.contact=organization
        }
        if(organization.providerInfo!=null){
            organization.providerInfo!!.contact=organization
        }
        if(organization.primaryLocation!=null){
            organization.primaryLocation!!.contact=organization
        }
    }


}