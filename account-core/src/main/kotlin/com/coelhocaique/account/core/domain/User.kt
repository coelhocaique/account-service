package com.coelhocaique.account.core.domain

import java.time.LocalDateTime
import java.util.*

data class User (
        val userId: UUID,
        val creationDate: LocalDateTime,
        val username: String,
        val firstName: String,
        val lastName: String,
        val email: String,
        val password: String
)