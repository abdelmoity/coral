package io.coral.contacts.model.domain

import javax.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "CONTACT_TYPE")
@Table(name = "CONTACT")

open class Contact : AbstractBasicDefinition() {

    @Column(name = "CONTACT_TYPE", insertable = false, updatable = false)
    var contactType: String? = null

    @Column(name = "TPA")
    var TPA: Boolean? = false

    @Column(name = "PROVIDER")
    var provider: Boolean? = false

    @Column(name = "PARTICIPANT")
    var participant: Boolean? = false

    @Column(name = "defaultTaxId")
    var defaultTaxId: String? = null

    @Column(name = "email" , length = 150)
    var email: String? = null

    @Column(name = "defaultPhone" , length = 10)
    var defaultPhone: String? = null

    /**
     * provider related information
     */
    @OneToOne
    @JoinColumn( name = "coralProviderId" , unique = true )
    var providerInfo: HealthcareProviderInfo? = null


    @OneToOne
    @JoinColumn( name = "coralTPAId" , unique = true )
    var tpaInfo: TPAInfo? = null

    @OneToOne
    @JoinColumn(unique = true , name = "coralParticipantId")
    var participantInfo: ParticipantInfo? = null

    @Column(name = "active" )
    var active: Boolean? = true

    @OneToMany(mappedBy = "contact" , cascade = [CascadeType.ALL], orphanRemoval = true)
    var locations: MutableList<Location>? = mutableListOf<Location>()


    @OneToOne
    @JoinColumn( name = "PRIMARY_LOCATION" )
    var primaryLocation: Location? = null





}