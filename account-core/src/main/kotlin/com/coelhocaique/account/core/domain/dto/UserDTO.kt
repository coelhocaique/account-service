package com.coelhocaique.account.core.domain.dto

import java.time.LocalDateTime
import java.util.*

data class UserDTO (
        val userId: UUID? = null,
        val username: String,
        val firstName: String,
        val lastName: String,
        val email: String,
        val password: String? = null,
        val creationDate: LocalDateTime? = null,
        val accounts: List<AccountDTO>? = null,
        val links: List<Map<String, String>>? = null
)