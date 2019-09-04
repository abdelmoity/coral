package io.coral.contacts.model.repository.impl

import io.coral.contacts.model.domain.TPAInfo
import java.io.Serializable
import javax.persistence.EntityManager
import javax.persistence.EntityManagerFactory

class TpaInfoRepositoryImpl: BasicRepositoryImpl() {
    @Throws(Exception::class)
    fun create(tpaInfo: TPAInfo) :TPAInfo{
        var em: EntityManager? = null
        try {
            em = entityManager
            em.transaction.begin()
            em.persist(tpaInfo)
            em.flush()
            em.transaction.commit()
            return tpaInfo
        } catch (ex: Exception) {
            throw ex
        } finally {
            em?.close()
        }
    }


}