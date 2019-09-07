package io.coral.contacts.model.repository

import javax.persistence.EntityManagerFactory
import javax.persistence.Persistence

object EMF {
    private  var emf: EntityManagerFactory ?= null
    fun getEMF(): EntityManagerFactory? {
        if(emf==null){
            emf = Persistence.createEntityManagerFactory("customersPU")
        }
        return emf
    }
}
