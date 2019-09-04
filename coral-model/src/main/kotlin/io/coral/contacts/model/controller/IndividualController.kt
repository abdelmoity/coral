package io.coral.contacts.model.controller

import io.coral.contacts.model.domain.Individual
import io.coral.contacts.model.domain.Location
import java.io.Serializable
import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory

class IndividualController : Serializable {
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
    fun create(individual: Individual) {
        var em: EntityManager? = null
        try {
            em = entityManager
            em.transaction.begin()
            em.persist(individual)
            em.transaction.commit()
        } catch (ex: Exception) {
            throw ex
        } finally {
            em?.close()
        }
    }


}
