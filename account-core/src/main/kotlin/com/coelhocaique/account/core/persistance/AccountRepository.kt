package com.coelhocaique.account.core.persistance

import com.coelhocaique.account.core.domain.Account
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono
import reactor.core.publisher.Mono.just
import java.util.*

@Component
class AccountRepository(val repository: DynamoRepository) {

    private companion object Const {
        const val TABLE_NAME = "account"
        const val USER_ID = "user_id"
    }

    fun insert(account: Account): Mono<Account> {
        repository.addItem(TABLE_NAME, account)
        return just(account)
    }

    fun findByUserId(userId: UUID): Mono<List<Account>> {
        return just(scan(mapOf(USER_ID to userId.toString())))
    }

    private fun scan(keys: Map<String, String>): List<Account> {
        return repository.scanItem(TABLE_NAME, keys, Account::class.java)
    }

}