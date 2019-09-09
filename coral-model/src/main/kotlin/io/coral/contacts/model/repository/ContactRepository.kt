package io.coral.contacts.model.repository

import io.coral.contacts.model.dto.ContactDTO
import io.coral.contacts.model.search.FilterFieldCriteria
import io.coral.contacts.model.search.SortField
import io.tech4health.ts.model.domain.AbstractEntity

interface ContactRepository:BasicRepository {

     fun delete(id:Int): Boolean

     fun searchContacts(filterBy:List<FilterFieldCriteria>, sortBy:List<SortField>, offset:Int, limit:Int):MutableList<ContactDTO>

     fun searchContactTotalCount(filterBy:List<FilterFieldCriteria>) :Int
}