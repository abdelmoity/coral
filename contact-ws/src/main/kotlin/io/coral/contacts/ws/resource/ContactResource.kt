package io.coral.contacts.ws.resource

import io.coral.contacts.model.repository.impl.LocationRepositoryImpl
import io.coral.contacts.ws.model.common.response.ContactResponse
import org.apache.http.HttpStatus
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("contacts")
class ContactResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun getContact(): Response {
        val result: MutableList<String> = mutableListOf()
        result.add("ASD")
        result.add("BCD")
        val l: LocationRepositoryImpl;
        val response = ContactResponse<List<String>>().withData(result)
        return Response.status(HttpStatus.SC_OK).entity(response).build()
    }


}

