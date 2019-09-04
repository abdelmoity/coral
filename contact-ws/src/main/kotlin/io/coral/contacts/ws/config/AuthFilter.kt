package io.coral.contacts.ws.config

import java.io.IOException
import javax.ws.rs.container.ContainerRequestContext
import javax.ws.rs.container.ResourceInfo
import javax.ws.rs.core.Context
import javax.ws.rs.ext.Provider

@Provider
class AuthFilter : javax.ws.rs.container.ContainerRequestFilter {

    @Context
    lateinit var resourceInfo: ResourceInfo

    @Throws(IOException::class)
    override fun filter(requestContext: ContainerRequestContext) {

    }
}
