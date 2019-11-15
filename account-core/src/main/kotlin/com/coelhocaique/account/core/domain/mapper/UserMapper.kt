package com.coelhocaique.account.core.domain.mapper

import com.coelhocaique.account.core.domain.User
import com.coelhocaique.account.core.domain.dto.UserDTO
import reactor.core.publisher.Mono.just
import java.time.LocalDateTime
import java.util.*

object UserMapper {

    fun toDocument(dto: UserDTO): User =
            User(userId = dto.userId ?: UUID.randomUUID(),
                    creationDate = LocalDateTime.now(),
                    username = dto.username,
                    email = dto.email,
                    firstName = dto.firstName,
                    lastName = dto.lastName,
                    password = dto.password!!)

    fun toDTO(document: User): UserDTO =
            UserDTO(userId = document.userId,
                    creationDate = document.creationDate,
                    username = document.username,
                    email = document.email,
                    firstName = document.firstName,
                    lastName = document.lastName)

    fun toMonoDTO(document: User) = just(toDTO(document))
}

