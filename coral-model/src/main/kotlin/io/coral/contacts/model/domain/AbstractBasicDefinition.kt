package io.coral.contacts.model.domain

import javax.persistence.*

@MappedSuperclass
abstract class AbstractBasicDefinition : AbstractEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    var id: Int? = null

    @Column(name = "NAME", length = 100, nullable = false)
    var name: String? = null

    @Column(name = "DESCRIPTION", length = 150)
    var description: String? = null
}
