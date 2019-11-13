package com.coelhocaique.account.core.domain.dto

import java.time.LocalDateTime
import java.util.*

data class UserDTO (
        val accountId: UUID,
        val username: String,
        val firstName: String,
        val lastName: String,
        val email: String,
        val password: String,
        val creationDate: LocalDateTime,
        val links: List<Map<String, String>>
)