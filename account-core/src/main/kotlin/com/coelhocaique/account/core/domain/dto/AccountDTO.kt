package com.coelhocaique.account.core.domain.dto

import com.coelhocaique.account.core.domain.enums.AccountType
import java.time.LocalDateTime
import java.util.UUID

data class AccountDTO (
        val accountId: UUID,
        val userId: UUID,
        val type: AccountType,
        val lastName: String,
        val email: String,
        val creationDate: LocalDateTime,
        val links: List<Map<String, String>>
)