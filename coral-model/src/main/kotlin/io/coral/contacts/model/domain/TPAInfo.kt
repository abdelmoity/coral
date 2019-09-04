package io.coral.contacts.model.domain


import javax.persistence.*

@Entity
@Table(name = "TPA_INFO")
open class TPAInfo : AbstractEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID" , nullable = false )
    var id: Int? = null

    @OneToOne(mappedBy = "tpaInfo")
    private val contact: Contact? = null


}