package com.coelhocaique.account.api.handler

data class FetchCriteria (
        val referenceCode: String? = null,
        val referenceDate: String? = null,
        val dateFrom: String? = null,
        val dateTo: String? = null,
        val id: String? = null,
        val propertyName: String? = null
){
    enum class SearchType {
        BY_ID,
        REFERENCE_CODE,
        REFERENCE_DATE,
        RANGE_DATE,
        PROPERTY_NAME
    }

    fun searchType(): SearchType? {
        if (id != null)
            return SearchType.BY_ID

        if (referenceCode != null)
            return SearchType.REFERENCE_CODE

        if (referenceDate != null)
            return SearchType.REFERENCE_DATE

        if (dateFrom != null && dateTo != null)
            return SearchType.RANGE_DATE

        if (propertyName != null)
            return SearchType.PROPERTY_NAME

        return null
    }

}