package com.coelhocaique.account.core.domain.dto

import com.coelhocaique.account.core.domain.enums.AccountType
import java.time.LocalDateTime
import java.util.UUID

data class AccountDTO (
        val accountId: UUID? = null,
        val userId: UUID,
        val type: AccountType = AccountType.DEFAULT,
        val creationDate: LocalDateTime? = null,
        val links: List<Map<String, String>>? = null
)