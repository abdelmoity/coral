package io.coral.contacts.model.repository

interface ContactRepository:BasicRepository {
     fun delete(id:Int): Boolean
}