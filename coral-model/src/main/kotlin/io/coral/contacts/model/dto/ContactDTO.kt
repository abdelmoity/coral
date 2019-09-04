package io.coral.contacts.model.dto

import io.coral.contacts.model.enums.StateEnum


class ContactDTO {

    /**
     * the identifier of the customer
     */
    var id: Int? = null

    /**
     * the name of the customer
     */
    var name: String? = null

    /**
     * Tax Identification Number (TIN) is a nine-digit number used as a tracking number by the U.S. Internal Revenue Service (IRS) and is required information on all tax returns filed with the IRS.
     */
    var taxId: String? = null

    /**
     * the street address of the customer
     */
    var street: String? = null

    /**
     * the address's zip code
     */
    var zipCode: String? = null

    /**
     * the city where the address exist
     */
    var city: String? =null

    /**
     * the fax number for the given address
     */
    var fax: String? = null

    /**
     * first phone number
     */
    var phone1: String? = null

    /**
     * second phone number
     */
    var phone2: String? = null

    /**
     * the provider flag
     */
    var provider: Boolean? = null

    /**
     * the tpa flag
     */
    var tpa: Boolean? = null

    /**
     * the contact email
     */
    var email: String? = null

    /**
     * the default phone
     */
    var defaultPhone: String? = null

    /**
     * participant flag
     */
    var participant: Boolean? = null

    /**
     *
     */
    var coralProviderId: Int? = null

    /**
     *
     */
    var coralTPAId: Int? = null

    /**
     *
     */
    var coralParticipantId: Int? = null

    /**
     * determines if contact is active or not
     */
    var active: Boolean? = null

    /**
     *
     */
    var state: StateEnum? = null

}