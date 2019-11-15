package com.coelhocaique.account.core.domain

import com.coelhocaique.account.core.domain.enums.AccountType
import java.time.LocalDateTime
import java.util.UUID

data class Account (
        val accountId: UUID?,
        val creationDate: LocalDateTime,
        val userId: UUID,
        val type: AccountType
)