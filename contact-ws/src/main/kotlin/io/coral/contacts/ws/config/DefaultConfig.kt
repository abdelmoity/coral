package io.coral.contacts.ws.config

import com.google.inject.Guice
import com.google.inject.Injector
import io.tech4health.ts.exception.T4HBaseException
import io.tech4health.ts.exception.T4HError
import io.tech4health.ts.exception.mapper.GenericExceptionMapper
import io.tech4health.ts.exception.mapper.NotFoundExceptionMapper
import io.tech4health.ts.exception.mapper.T4HBaseExceptionMapper
import org.glassfish.hk2.api.ServiceLocator
import org.glassfish.jersey.media.multipart.MultiPartFeature
import org.glassfish.jersey.server.ResourceConfig
import org.jvnet.hk2.guice.bridge.api.GuiceBridge
import org.jvnet.hk2.guice.bridge.api.GuiceIntoHK2Bridge
import javax.inject.Inject
import javax.ws.rs.ApplicationPath


@ApplicationPath("api/")
class DefaultConfig() : ResourceConfig() {

    @Inject
    constructor(serviceLocator: ServiceLocator) : this() {
        packages(true, "io.coral.contacts.ws.resource")
        register(GuiceModule())
        register(MultiPartFeature::class.java)
        registerClasses(
            GenericExceptionMapper::class.java,
            T4HBaseExceptionMapper::class.java,
            NotFoundExceptionMapper::class.java,
            T4HError::class.java,
            T4HBaseException::class.java
        )
        // register(ApiListingResource::class.java)
       // register(SwaggerSerializers::class.java)
        register(CORSFilter::class.java)
        val injector = Guice.createInjector(GuiceModule())
        initGuiceIntoHK2Bridge(serviceLocator, injector)
    }

    private fun initGuiceIntoHK2Bridge(serviceLocator: ServiceLocator, injector: Injector) {
        GuiceBridge.getGuiceBridge().initializeGuiceBridge(serviceLocator)
        val guiceBridge = serviceLocator.getService(GuiceIntoHK2Bridge::class.java)
        guiceBridge.bridgeGuiceInjector(injector)
    }

}
