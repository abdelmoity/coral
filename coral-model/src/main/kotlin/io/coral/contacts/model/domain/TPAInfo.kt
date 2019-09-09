package io.coral.contacts.model.domain


import com.fasterxml.jackson.annotation.JsonIgnore
import io.tech4health.ts.model.domain.AbstractEntity
import javax.persistence.*

@Entity
@Table(name = "TPA_INFO")
open class TPAInfo : AbstractEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID" , nullable = false )
    var id: Int? = null

    @OneToOne(mappedBy = "tpaInfo")
    @JsonIgnore
     var contact: Contact? = null


}