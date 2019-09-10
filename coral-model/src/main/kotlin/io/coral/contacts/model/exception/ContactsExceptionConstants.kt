package io.coral.contacts.model.exception

import com.google.common.base.MoreObjects
import io.tech4health.ts.exception.T4HExceptionCode

enum class ContactsExceptionConstants
constructor(private val exception: T4HExceptionCode) {
    GENERIC_APP_ERROR_CODE(
        T4HExceptionCode(3001, "general exception occurred")
    ),
    OBJECT_NOT_FOUND(
        T4HExceptionCode(3002, "object not found")
    ),
    ENUM_WRONG_VALUE(
        T4HExceptionCode(3003, "enum with wrong value ")
    ),
    MODEL_MAPPING_ERROR(
        T4HExceptionCode(3004, "Failed to map models")
    ),
    CONFLICT_EXCEPTION(
        T4HExceptionCode(3005, "value conflict exception")
    );

    val code: Int
        get() = exception.code

    val desc: String
        get() = exception.desc

    override fun toString(): String {
        return MoreObjects.toStringHelper(this)
            .add("exception", exception)
            .toString()
    }
}