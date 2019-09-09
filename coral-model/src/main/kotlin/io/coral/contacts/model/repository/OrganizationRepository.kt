package io.coral.contacts.model.repository

import io.coral.contacts.model.domain.Organization

interface OrganizationRepository :ContactRepository{
    fun add(organization:Organization):Organization
    fun getById(id: Int): Organization
    fun update(organization:Organization):Organization
}