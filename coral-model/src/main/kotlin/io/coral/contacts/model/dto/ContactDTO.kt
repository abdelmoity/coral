package io.coral.contacts.model.dto
import java.io.Serializable
open class ContactDTO :Serializable{

    var id: Int? = null
    var name: String? = null
    var primaryLocation: LocationDto? = null
//    var taxId: String? = null
//    var street: String? = null
//    var zipCode: String? = null
//    var city: String? =null
//    var fax: String? = null
//    var phone1: String? = null
//    var phone2: String? = null
    var defaultTaxId: String? = null
    var provider: Boolean? = null
    var tpa: Boolean? = null
    var email: String? = null
    var defaultPhone: String? = null
    var participant: Boolean? = null
    var coralProviderId: Int? = null
    var coralTPAId: Int? = null
    var coralParticipantId: Int? = null
    var active: Boolean? = null
    var locations: MutableList<LocationDto> = mutableListOf<LocationDto>()
    var tpaInfo: TPAInfoDto? = null
    var participantInfo: ParticipantInfoDto? = null
    var providerInfo: HealthCareProviderInfoDto? = null

}