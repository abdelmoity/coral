package io.coral.contacts.model.repository

import io.coral.contacts.model.dto.ContactDTO
import io.coral.contacts.model.search.FilterFieldCriteria
import io.coral.contacts.model.search.SearchDto
import io.coral.contacts.model.search.SortField
import io.tech4health.ts.model.domain.AbstractEntity

interface ContactRepository:BasicRepository {

     fun delete(id:Int): Boolean

     fun searchContacts(searchDto: SearchDto):MutableList<ContactDTO>

     fun searchContactTotalCount(filterBy:List<FilterFieldCriteria>) :Int
}