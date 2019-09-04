package io.coral.contacts.model.domain

import io.coral.contacts.model.constant.ContactConstants
import javax.persistence.DiscriminatorValue
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "ORGANIZATION_CONTACT")
@DiscriminatorValue(ContactConstants.ORGANIZATION_CONTACT_TYPE)
open class Organization : Contact()