package io.coral.contacts.model.controller

import io.coral.contacts.model.domain.Location

import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory
import java.io.Serializable

class LocationController : Serializable {
    private var emf: EntityManagerFactory? = null
    private var em: EntityManager? = null
    val entityManager: EntityManager
        get() = emf!!.createEntityManager()

    constructor(emf: EntityManagerFactory) {
        this.emf = emf
    }

    constructor(em: EntityManager) {
        this.em = em
    }

    /*
    Transcations
     */
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
