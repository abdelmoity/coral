package io.coral.contacts.ws.resource

import io.coral.contacts.model.domain.Organization
import io.coral.contacts.model.dto.ContactDTO
import io.coral.contacts.model.repository.ContactRepository
import io.coral.contacts.model.repository.OrganizationRepository
import io.coral.contacts.model.repository.impl.ContactRepositoryImpl
import io.coral.contacts.model.repository.impl.OrganizationRepositoryImpl
import io.coral.contacts.model.search.SearchDto
import io.coral.contacts.ws.model.common.response.ContactResponse
import org.apache.commons.httpclient.HttpStatus
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/contacts")
class ContactResource {
    @POST
    @Path("/index")
    @Produces(MediaType.APPLICATION_JSON)
    fun getContact(searchDto:SearchDto): Response {
        val contactRepo: ContactRepository=ContactRepositoryImpl()
        val contactsResult = contactRepo.searchContacts(searchDto)
        val totalCount = contactRepo.searchContactTotalCount(searchDto)
        val response = ContactResponse<MutableList<ContactDTO>>().withData(contactsResult).withTotalCount(totalCount)
        return Response.status(HttpStatus.SC_OK).entity(response).build()
    }


    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    fun getById(@PathParam("id") id: Int): Response {
        val organizationRepo: OrganizationRepository=OrganizationRepositoryImpl()
        val organizationDto = organizationRepo.getById(id)
        val response = ContactResponse<Organization>().withData(organizationDto)
        return Response.status(HttpStatus.SC_OK).entity(response).build()

    }


    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun addNewOrganization(organization: Organization): Response {
        val organizationRepo: OrganizationRepository=OrganizationRepositoryImpl()
        val result = organizationRepo.add(organization)
        val response = ContactResponse<Organization>().withData(result).build()
        return Response.status(Response.Status.CREATED).entity(response).build()
    }

    // Update
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun updateOrganization(organization: Organization): Response {
        val organizationRepo: OrganizationRepository=OrganizationRepositoryImpl()
        val result = organizationRepo.update(organization)
        val response = ContactResponse<Organization>().withData(result).build()
        return Response.status(Response.Status.OK).entity(response).build()
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    fun deleteContact(@PathParam("id") id: Int): Response {
        val organizationRepo: OrganizationRepository=OrganizationRepositoryImpl()
        val deletedResult = organizationRepo.delete(id)
        val response = ContactResponse<Boolean>().withData(deletedResult)
        return Response.status(HttpStatus.SC_OK).entity(response).build()
    }





}

