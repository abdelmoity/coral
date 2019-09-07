package io.coral.contacts.model.domain


import io.tech4health.ts.model.domain.AbstractBasicDefinition
import javax.persistence.*


@Entity
@Table(name = "LOCATION")
open class Location : AbstractBasicDefinition() {

    /**
     * Tax Identification Number (TIN) is a nine-digit number used as a tracking number by the U.S. Internal Revenue Service (IRS) and is required information on all tax returns filed with the IRS.
     */
    @Column(name = "TAX_ID" , length = 9)
    var taxId: String? = null

    /**
     * first phone number for the location
     */
    @Column(name = "PHONE1" , length = 10)
    var phone1: String? = null

    /**
     * second phone number of the location
     */
    @Column(name = "PHONE2" , length = 10)
    var phone2: String? = null

    /**
     * the fax number  of the location
     */
    @Column(name = "FAX" , length = 10)
    var fax: String? = null

    /**
     * the address of the location
     */
    @Embedded
    var address:Address?=Address()

    @ManyToOne
    @JoinColumn(name = "CONTACT_ID")
    var contact: Contact? = null




}