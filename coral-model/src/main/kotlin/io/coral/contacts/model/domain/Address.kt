package io.coral.contacts.model.domain

import io.coral.contacts.model.enums.StateEnum
import javax.persistence.Column
import javax.persistence.Embeddable
import javax.persistence.EnumType
import javax.persistence.Enumerated

@Embeddable
open class Address {

    /**
     * the details information of the address
     */
    @Column(name = "STREET")
    var street: String? = null

    /**
     * Represents the zip code or postal code for the address, 5 digits, which can start with 0
     */
    @Column(name = "ZIP_CODE")
    var zipCode: String? = null

    /**
     * the city where the street exist.
     */
    @Column(name = "CITY")
    var city: String? = null

    /**
     * the address's state
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "STATE")
    var state: StateEnum? = null

}