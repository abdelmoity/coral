package io.coral.contacts.model.domain


import com.fasterxml.jackson.annotation.JsonIgnore
import io.tech4health.ts.model.domain.AbstractEntity
import javax.persistence.*

@Entity
@Table(name = "HEALTHCARE_PROVIDER_INFO")
@NamedQueries(
    NamedQuery(name = "HealthcareProviderInfo.getByNpi", query = "SELECT count(H) FROM HealthcareProviderInfo H where H.npi=:npi")
)
open class HealthcareProviderInfo : AbstractEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID" , nullable = false )
    var id: Int? = null

    /**
     * A National Provider Identifier (NPI) is a unique 10-digit identification number issued to health care providers in the United States by the Centers for Medicare and Medicaid Services (CMS).
     */
    @Column(name = "NPI" , nullable = false , unique = true)
    var npi: String? = null

    /**
     * lists the speciality of the provider, this should list a comma separated items represent the taxonomy description in  NPI registry.
     */
    @Column(name = "SPECIALITY" , nullable = false , length = 200)
    var speciality: String? = null

    @OneToOne(mappedBy = "providerInfo")
    @JsonIgnore
     var contact: Contact? = null


}