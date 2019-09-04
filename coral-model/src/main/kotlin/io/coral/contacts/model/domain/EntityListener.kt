 package io.coral.contacts.model.domain


import javax.persistence.PrePersist

open class EntityListener {
    @PrePersist
    open fun beforeAnyPersist(abstractEntity: AbstractEntity) {
//        val principal = EJBUtils.resolveSecurityService(SecurityService::class.java).getCurrentPrincipal()
//        if (abstractEntity.createdBy.isNullOrEmpty()) {
//            abstractEntity.createdBy = principal.username
//        }
//        abstractEntity.lastModifiedBy = principal.username
    }
}