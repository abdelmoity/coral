package io.coral.contacts.model.mapper

import io.coral.contacts.model.domain.Contact
import io.coral.contacts.model.dto.ContactDTO
import io.coral.contacts.model.exception.ContactsDefaultException
import io.tech4health.ts.model.common.mapper.AbstractModelMapper

class ContactModelMapper : AbstractModelMapper<Contact, ContactDTO>() {
    override fun convertToDto(input: Contact): ContactDTO {
        try {
            val dto: ContactDTO = BasicModelMapper.convertTo(input, ContactDTO()) as ContactDTO
            if (input.tpaInfo != null) {
                dto.coralTPAId = input.tpaInfo!!.id
            }
            if (input.participantInfo != null) {
                dto.coralParticipantId = input.participantInfo!!.id
            }
            if (input.providerInfo != null) {
                dto.coralProviderId = input.providerInfo!!.id
            }
            // primary Location
            if (input.primaryLocation != null) {
                val primaryLocation = input.primaryLocation!!
                dto.street = primaryLocation.address!!.street
                dto.zipCode = primaryLocation.address!!.zipCode
                dto.city = primaryLocation.address!!.city
                dto.fax = primaryLocation.fax
                dto.phone1 = primaryLocation.phone1
                dto.phone2 = primaryLocation.phone2
            }
            return dto
        } catch (e: Exception) {
            throw ContactsDefaultException(e)
        }
    }

    override fun convertToEntity(input: ContactDTO): Contact {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun updateEntity(input:Contact){
        input.locations.forEach { it.contact = input }
        if(input.tpaInfo!=null){
            input.tpaInfo!!.contact=input
        }
        if(input.providerInfo!=null){
            input.providerInfo!!.contact=input
        }
        if(input.primaryLocation!=null){
            input.primaryLocation!!.contact=input
        }
    }

}





