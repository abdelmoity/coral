package io.coral.contacts.model.mapper

import org.modelmapper.ModelMapper

object BasicModelMapper {
    fun convertTo(from: Any, to: Any): Any {
        val mapper = ModelMapper()
        return mapper.map(from, to.javaClass)
    }
}
