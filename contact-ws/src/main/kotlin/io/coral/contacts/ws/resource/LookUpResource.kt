package io.coral.contacts.ws.resource

import io.coral.contacts.model.enums.StateEnum
import io.coral.contacts.ws.model.common.response.ContactResponse
import org.apache.commons.httpclient.HttpStatus
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response


@Path("/lookups")
class LookUpResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/state")

    fun getStates( ): Response {
        val lookups: MutableList<String> = mutableListOf<String>()
        StateEnum.values().forEach {
            lookups.add(it.label)
        }

        val response = ContactResponse<List<String>>().withData(lookups)
        return Response.status(HttpStatus.SC_OK).entity(response).build()
    }



}