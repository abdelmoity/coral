package io.coral.contacts.model.domain


import javax.persistence.*

@Entity
@Table(name = "PARTICIPANT_INFO")
open class ParticipantInfo : AbstractEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID" , nullable = false )
    var id: Int? = null

    @Column(name = "employer")
    var employer: String? = null

    @OneToOne(mappedBy = "participantInfo")
    var contact: Contact? = null

}