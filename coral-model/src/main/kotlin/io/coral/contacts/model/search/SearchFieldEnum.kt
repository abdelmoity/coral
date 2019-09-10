package io.coral.contacts.model.search

enum class SearchFieldEnum(var entityField:String) {
    taxId("C.defaultTaxId"),
    street("L.address.street"),
    zipCode("L.address.zipCode"),
    city("L.address.city"),
    phone1("L.phone1"),
    phone2("L.phone2"),
    fax("L.fax"),
    provider("C.provider"),
    tpa("C.TPA"),
    coralProviderId("C.providerInfo.id"),
    coralTPAId("C.tpaInfo.id"),
    coralParticipantId("C.participantInfo.id");
}