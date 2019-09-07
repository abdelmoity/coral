package io.coral.contacts.model.repository.impl

import io.coral.contacts.model.domain.Contact
import io.coral.contacts.model.repository.ContactRepository

open class ContactRepositoryImpl:ContactRepository,BasicRepositoryImpl() {

    override fun delete(id: Int): Boolean {
        return doDelete(Contact(),id)
    }




}