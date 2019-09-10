package io.coral.contacts.model.exception

import io.tech4health.ts.exception.T4HBaseException
import org.apache.commons.httpclient.HttpStatus

class ContactConflictException : T4HBaseException {

    constructor() : super(
        HttpStatus.SC_CONFLICT,
        ContactsExceptionConstants.CONFLICT_EXCEPTION.code,
        ContactsExceptionConstants.CONFLICT_EXCEPTION.desc
    )

    constructor(desc: String, conflictingId: Int) : super(
        HttpStatus.SC_CONFLICT,
        ContactsExceptionConstants.CONFLICT_EXCEPTION.code,
        desc){
        moreInfo = conflictingId.toString()
    }
    constructor(desc: String) : super(
        HttpStatus.SC_CONFLICT,
        ContactsExceptionConstants.CONFLICT_EXCEPTION.code,
        desc){
    }

    constructor(status: Int, code: Int, desc: String) : super(status, code, desc)

    constructor(status: Int, code: Int, desc: String, exception: Exception) : super(status, code, desc, exception)
}