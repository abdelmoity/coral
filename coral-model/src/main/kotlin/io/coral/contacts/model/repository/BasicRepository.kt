package io.coral.contacts.model.repository


import io.tech4health.ts.model.domain.AbstractEntity

interface BasicRepository {

    fun doAdd(entity: AbstractEntity): AbstractEntity

    fun doUpdate(entity: AbstractEntity): AbstractEntity

    fun doDelete(entity:AbstractEntity,id:Int): Boolean?

    fun findAll(entity: String, offset: Int, maxSize: Int): List<AbstractEntity>

}
