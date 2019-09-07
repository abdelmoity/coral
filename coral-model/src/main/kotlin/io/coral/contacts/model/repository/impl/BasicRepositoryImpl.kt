package io.coral.contacts.model.repository.impl

import io.coral.contacts.model.exception.ObjectNotFoundException
import io.coral.contacts.model.repository.BasicRepository
import io.coral.contacts.model.repository.EMF
import io.tech4health.ts.model.domain.AbstractEntity
import javax.persistence.EntityManager

open class BasicRepositoryImpl : BasicRepository {


    val entityManager: EntityManager
        get() = EMF.getEMF()!!.createEntityManager()




    override fun doAdd(entity: AbstractEntity): AbstractEntity {
        var em: EntityManager? = null
        try {
            em = entityManager
            em.transaction.begin()
            em.persist(entity)
            em.flush()
            em.transaction.commit()
            return entity
        } catch (ex: Exception) {
            throw ex
        } finally {
            em!!.close()
        }
    }

    override fun doUpdate(entity: AbstractEntity): AbstractEntity {
        var em: EntityManager? = null
        try {
            em = entityManager
            em.transaction.begin()
            em.merge(entity)
            em.transaction.commit()
            return entity
        } catch (ex: Exception) {
            throw ex
        } finally {
            em!!.close()
        }
    }

    override fun doDelete(entity: AbstractEntity,id:Int): Boolean {
        var em: EntityManager? = null
        try {
            em = entityManager
            em.transaction.begin()
            val toBeRemoved= em.find(entity::class.java,id) ?:throw ObjectNotFoundException()
            em.remove(toBeRemoved)
            em.transaction.commit()
            return true
        } catch (ex: Exception) {
            throw ex
        } finally {
            em!!.close()
        }
    }

    override fun findAll(entity: String, offset: Int, maxSize: Int): List<AbstractEntity> {
        var em: EntityManager? = null
        try {
            em = entityManager
            return em.createNamedQuery(entity +".findAll").setFirstResult(offset).setMaxResults(maxSize).resultList as List<AbstractEntity>
        } catch (ex: Exception) {
            throw ex
        } finally {
            em!!.close()
        }
    }


}
