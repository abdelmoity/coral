package io.coral.contacts.model.search

enum class SearchFieldEnum(var entityField:String) {
    taxId("C.defaultTaxId"),
    street("L.locations.address.street"),
    zipCode("L.locations.address.zipCode"),
    city("L.locations.address.city"),
    phone1("L.locations.phone1"),
    phone2("L.locations.phone2"),
    provider("C.provider"),
    tpa("C.TPA"),
    coralProviderId("C.providerInfo.id"),
    coralTPAId("C.tpaInfo.id"),
    coralParticipantId("C.participantInfo.id");
}