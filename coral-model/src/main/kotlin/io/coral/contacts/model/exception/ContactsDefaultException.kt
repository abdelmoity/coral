package io.coral.contacts.model.exception

import io.tech4health.ts.exception.T4HBaseException
import org.apache.commons.httpclient.HttpStatus
import javax.validation.ConstraintViolationException

class ContactsDefaultException:T4HBaseException {
    constructor(e: Exception)  {
        if (e is ConstraintViolationException) {
            throw T4HBaseException(e,getConstrainViolationMessages(e))
        } else {
            throw T4HBaseException(
                HttpStatus.SC_INTERNAL_SERVER_ERROR,
                ContactsExceptionConstants.GENERIC_APP_ERROR_CODE.code,
                e.message!!,
                e
            )
        }
    }

    fun getConstrainViolationMessages(ce: ConstraintViolationException):String{
        val violationSet = ce.constraintViolations
        val messages = arrayOfNulls<String>(violationSet.size)
        var i = 0
        violationSet.forEach{
            messages[i] = it.message
            i++
        }
        return messages.joinToString()
    }
}