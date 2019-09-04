package io.coral.contacts.model.domain

import io.coral.contacts.model.constant.ContactConstants
import io.coral.contacts.model.enums.NameSuffixeEnum
import io.coral.contacts.model.enums.SexEnum
import io.coral.contacts.model.enums.TitleEnum
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "INDIVIDUAL_CONTACT" ,
    indexes = [Index(name = "name_index", columnList = "FIRST_NAME,LAST_NAME,DOB" , unique = true)])
@DiscriminatorValue(ContactConstants.INDIVIDUAL_CONTACT_TYPE)
@NamedQueries(
      NamedQuery(name = "Individual.findAll", query = "SELECT c FROM Individual c")
    , NamedQuery(name = "Individual.findById", query = "SELECT c FROM Individual c WHERE c.id = :id")
    , NamedQuery(name = "Individual.findByName", query = "SELECT c FROM Individual c WHERE c.name = :name")
)
open class Individual : Contact() {

    /**
     * the first name of individual
     */
    @Column(name = "FIRST_NAME" , length = 30, nullable = true )
    var firstName: String? = null

    /**
     * the middle name of the individual
     */
    @Column(name = "MIDDLE_NAME" , length = 30, nullable = true )
    var middleName: String? = null

    /**
     * last name of individual NPI
     */
    @Column(name = "LAST_NAME" , length = 30, nullable = true )
    var lastName: String? = null

    /**
     * individual date of birth
     */
    @Column(name = "DOB"  )
    var dateOfBirth: Date? = null

    /**
     * the sex of the individual
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "SEX")
    var sex: SexEnum? = null

    /**
     * the individual name's suffix
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "NAME_SUFFIX")
    var nameSuffix: NameSuffixeEnum? = null

    @Enumerated(EnumType.STRING)
    @Column(name = "TITLE")
    var title: TitleEnum? = null

}