package io.coral.contacts.model.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import io.tech4health.ts.model.domain.AbstractBasicDefinition
import javax.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "CONTACT_TYPE")
@Table(name = "CONTACT")

open class Contact : AbstractBasicDefinition() {

    @Column(name = "CONTACT_TYPE", insertable = false, updatable = false)
    @JsonIgnore
    var contactType: String? = null

    @Column(name = "TPA")
    var TPA: Boolean = false

    @Column(name = "PROVIDER")
    var provider: Boolean = false

    @Column(name = "PARTICIPANT")
    var participant: Boolean = false

    @Column(name = "defaultTaxId")
    var defaultTaxId: String? = null

    @Column(name = "email" , length = 150)
    var email: String? = null

    @Column(name = "defaultPhone" , length = 10)
    var defaultPhone: String? = null

    /**
     * provider related information
     */
    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn( name = "coralProviderId" , unique = true )
    var providerInfo: HealthcareProviderInfo? = null


    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn( name = "coralTPAId" , unique = true )
    var tpaInfo: TPAInfo? = null

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(unique = true , name = "coralParticipantId")
    var participantInfo: ParticipantInfo? = null

    @Column(name = "active" )
    var active: Boolean? = true

    @OneToMany(mappedBy = "contact" , cascade = [CascadeType.ALL])
    var locations: MutableList<Location> = mutableListOf<Location>()


    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn( name = "PRIMARY_LOCATION" )
    var primaryLocation: Location? = null





}