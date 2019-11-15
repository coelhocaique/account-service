package com.coelhocaique.account.core.service

import com.coelhocaique.account.core.domain.dto.AccountDTO
import com.coelhocaique.account.core.domain.dto.UserDTO
import com.coelhocaique.account.core.domain.enums.AccountType
import com.coelhocaique.account.core.domain.mapper.AccountMapper
import com.coelhocaique.account.core.domain.mapper.AccountMapper.toDTO
import com.coelhocaique.account.core.domain.mapper.AccountMapper.toDocument
import com.coelhocaique.account.core.domain.mapper.AccountMapper.toMonoDTO
import com.coelhocaique.account.core.domain.mapper.UserMapper
import com.coelhocaique.account.core.persistance.AccountRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import reactor.core.publisher.Mono.just
import java.util.*

@Service
class AccountService(private val repository: AccountRepository) {

    fun create(dto: AccountDTO): Mono<AccountDTO> {
        return repository.insert(toDocument(dto))
                .flatMap { toMonoDTO(it) }
    }

    fun findByUserId(userId: UUID): Mono<List<AccountDTO>> {
        return repository.findByUserId(userId)
                .map { it.map { itt ->  toDTO(itt)} }
    }

}