package com.coelhocaique.account.api.dto

import java.util.*

data class UserRequestDTO (
        val userId: UUID? = null,
        val username: String? = null,
        val firstName: String? = null,
        val lastName: String? = null,
        val email: String? = null,
        val password: String? = null,
        val user: String? = null
)