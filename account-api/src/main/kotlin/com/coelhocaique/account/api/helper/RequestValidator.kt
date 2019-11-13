package com.coelhocaique.account.api.helper

import com.coelhocaique.account.api.helper.Messages.NOT_NULL

object RequestValidator {


    private fun nonNull(o: Any?, attr: String) = requireNotNull(o, { NOT_NULL.format(attr)})

}