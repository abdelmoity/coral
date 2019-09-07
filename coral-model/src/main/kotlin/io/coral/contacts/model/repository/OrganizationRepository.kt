package io.coral.contacts.model.repository

import io.coral.contacts.model.domain.Organization
import io.coral.contacts.model.dto.OrganizationDto

interface OrganizationRepository :ContactRepository{
    fun add(dto:OrganizationDto):OrganizationDto
    fun getById(id: Int): OrganizationDto
    fun update(dto:OrganizationDto):OrganizationDto
}