package com.coelhocaique.account.api.helper

object Messages {
    const val DEFAULT_ERROR_MESSAGE = "Internal error, please try again."
    const val NO_PARAMETERS = "No parameters informed."
    const val MISSING_HEADERS = "Not authorized to perform the request."
    const val NOT_NULL = "%s must not be null."
    const val INVALID_REQUEST = "Invalid request body ."
}

object Fields {
    const val ID = "id"
    const val ACCOUNT_ID = "account_id"
    const val REF_DATE = "reference_date"
    const val REF_CODE = "reference_code"
    const val DATE_FROM = "date_from"
    const val DATE_TO = "date_to"
}