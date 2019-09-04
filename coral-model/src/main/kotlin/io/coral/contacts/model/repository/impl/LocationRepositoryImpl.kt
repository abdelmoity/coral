package io.coral.contacts.model.repository.impl

import io.coral.contacts.model.domain.Location

import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import java.io.Serializable

class LocationRepositoryImpl : BasicRepositoryImpl() {
    @Throws(Exception::class)
    fun create(location: Location) {
        var em: EntityManager? = null
        try {
            em = entityManager
            em.transaction.begin()
            em.persist(location)
            em.transaction.commit()
        } catch (ex: Exception) {
            throw ex
        } finally {
            em?.close()
        }
    }


}
