package io.coral.contacts.model.search

import io.coral.contacts.model.enums.OperationTypeEnum

class FilterFieldCriteria {

    /**
     * the name of the field to search
     */
    var field: String? = null

    /**
     * the value to search with in the given field
     */
    var value: String? = null

    /**
     * the operator between the two operands
     */
    var operator: OperationTypeEnum? = null

}