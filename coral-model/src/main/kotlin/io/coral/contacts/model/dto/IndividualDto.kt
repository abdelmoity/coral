package io.coral.contacts.model.dto

import io.coral.contacts.model.enums.NameSuffixeEnum
import io.coral.contacts.model.enums.SexEnum
import io.coral.contacts.model.enums.TitleEnum
import java.util.*

class IndividualDto:ContactDTO() {
    var firstName: String? = null
    var middleName: String? = null
    var lastName: String? = null
    var dateOfBirth: Date? = null
    var sex: SexEnum? = null
    var nameSuffix: NameSuffixeEnum? = null
    var title: TitleEnum? = null
}