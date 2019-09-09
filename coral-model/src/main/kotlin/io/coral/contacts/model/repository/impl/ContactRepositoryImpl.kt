package io.coral.contacts.model.repository.impl

import io.coral.contacts.model.domain.Contact
import io.coral.contacts.model.dto.ContactDTO
import io.coral.contacts.model.exception.ContactsDefaultException
import io.coral.contacts.model.exception.ObjectNotFoundException
import io.coral.contacts.model.mapper.BasicModelMapper
import io.coral.contacts.model.mapper.ContactModelMapper
import io.coral.contacts.model.repository.BasicRepository
import io.coral.contacts.model.repository.ContactRepository
import io.coral.contacts.model.repository.EMF
import io.coral.contacts.model.search.FilterFieldCriteria
import io.coral.contacts.model.search.OperationTypeEnum
import io.coral.contacts.model.search.SortField
import io.tech4health.ts.model.domain.AbstractEntity
import javax.persistence.EntityManager
import javax.persistence.TypedQuery

open class ContactRepositoryImpl:ContactRepository,BasicRepositoryImpl() {



    override fun delete(id: Int): Boolean {
        return this.doDelete(Contact(),id)
    }

    override fun searchContacts(filterBy:List<FilterFieldCriteria>,sortBy:List<SortField>,offset:Int,limit:Int):MutableList<ContactDTO>{
      try {
          val query = buildQuerySearchContacts(filterBy, sortBy).setFirstResult(offset).setMaxResults(limit)
          val entityResult = query.resultList
          val contactDtoList: MutableList<ContactDTO> = mutableListOf()//BasicModelMapper.convertTo(entityResult, mutableListOf(ContactDTO())) as MutableList<ContactDTO>
          val contactMapper=ContactModelMapper()
          entityResult.forEach {
              contactDtoList.add(contactMapper.convertToDto(it))
          }
          return contactDtoList
      }catch (ex:Exception){
          throw ContactsDefaultException(ex)
      }finally {
          entityManager.close()
      }
    }

    override fun searchContactTotalCount(filterBy:List<FilterFieldCriteria>) :Int {
        try{
       return  buildQuerySearchContacts(filterBy, emptyList()).resultList.size
        }catch (ex:Exception){
            throw ContactsDefaultException(ex)
        }finally {
            entityManager.close()
        }
    }

    private fun buildQuerySearchContacts(filterBy:List<FilterFieldCriteria>,sortBy:List<SortField>): TypedQuery<Contact> {
    val strQuery=StringBuilder("select C from Contact C where C.id is not null ")
       // filterBy
        filterBy.forEach {
           val column= it.field
            val value=it.value
            val operator=it.operator
            if (operator!!.equals(OperationTypeEnum.Contains)){
                strQuery.append(" AND C.$column like '%$value%' ")
            }else{
                strQuery.append(" AND C.$column = '$value' ")
            }
        }
        // sortBy
        if (!sortBy.isNullOrEmpty()) {
            strQuery.append(" ORDER BY ")
        }
        var sortIndex = 0
        sortBy.forEach {
            if (sortIndex > 0) {
                strQuery.append(",")
            }
            strQuery.append(" C.${it.field}  ${it.order.toString()} ")
            sortIndex++
        }

        val query: TypedQuery<Contact> = entityManager.createQuery(strQuery.toString(), Contact::class.java)
        return query
    }



}