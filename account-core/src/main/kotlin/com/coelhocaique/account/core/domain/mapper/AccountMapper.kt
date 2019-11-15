package com.coelhocaique.account.core.domain.mapper

import com.coelhocaique.account.core.domain.Account
import com.coelhocaique.account.core.domain.dto.AccountDTO
import reactor.core.publisher.Mono.just
import java.time.LocalDateTime
import java.util.*

object AccountMapper {

    fun toDocument(dto: AccountDTO): Account =
            Account(accountId = dto.accountId ?: UUID.randomUUID(),
                    userId = dto.userId,
                    creationDate = LocalDateTime.now(),
                    type = dto.type)

    fun toDTO(document: Account): AccountDTO =
            AccountDTO(accountId = document.accountId,
                    userId = document.userId,
                    creationDate = LocalDateTime.now(),
                    type = document.type)

    fun toMonoDTO(document: Account) = just(toDTO(document))

}

