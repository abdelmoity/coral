package io.coral.contacts.model.domain

import java.util.*
import javax.persistence.Column
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass

@MappedSuperclass
@EntityListeners(EntityListener::class)
abstract class AbstractEntity {

    constructor() {
        if (createdAt == null) {
            createdAt = Date()
        }
        lastModifiedAt = Date()
    }

    @Column(name = "CREATED_BY")
    var createdBy: String? = null

    @Column(name = "LAST_MODIFIED_BY")
    var lastModifiedBy: String? = null

    @Column(name = "CREATED_AT")
    var createdAt: Date? = null

    @Column(name = "LAST_MODIFIED_AT")
    var lastModifiedAt: Date? = null

}