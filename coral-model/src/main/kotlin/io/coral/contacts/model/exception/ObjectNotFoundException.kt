package io.coral.contacts.model.exception

import io.tech4health.ts.exception.T4HBaseException
import org.apache.commons.httpclient.HttpStatus

class ObjectNotFoundException: T4HBaseException {
    constructor() : super(
        HttpStatus.SC_NOT_FOUND,
        ContactsExceptionConstants.OBJECT_NOT_FOUND.code,
        ContactsExceptionConstants.OBJECT_NOT_FOUND.desc
    )

    constructor(desc: String) : super(
        HttpStatus.SC_NOT_FOUND,
        ContactsExceptionConstants.OBJECT_NOT_FOUND.code,
        desc
    )

    constructor(status: Int, code: Int, desc: String) : super(status, code, desc)

    constructor(status: Int, code: Int, desc: String, exception: Exception) : super(status, code, desc, exception)
}