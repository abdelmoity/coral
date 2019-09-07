package io.coral.contacts.model.dto

import io.coral.contacts.model.enums.StateEnum

class AddressDto {
        var street: String? = null
        var zipCode: String? = null
        var city: String? = null
        var state: StateEnum? = null
}