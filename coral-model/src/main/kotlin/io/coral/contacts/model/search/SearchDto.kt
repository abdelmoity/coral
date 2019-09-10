package io.coral.contacts.model.search

import java.io.Serializable

class SearchDto:Serializable {
    var filterBy:List<FilterFieldCriteria> = mutableListOf()
    var sortBy:List<SortField> = mutableListOf()
    var offset:Int=0
    var limit:Int=25
}