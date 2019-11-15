package com.coelhocaique.account.core.persistance

import com.coelhocaique.account.core.domain.User
import org.springframework.stereotype.Component
import reactor.core.publisher.Mono
import reactor.core.publisher.Mono.just

@Component
class UserRepository(val repository: DynamoRepository) {

    private companion object Const {
        const val TABLE_NAME = "user"
        const val EMAIL = "email"
        const val USERNAME = "username"
    }

    fun insert(user: User): Mono<User> {
        repository.addItem(TABLE_NAME, user)
        return just(user)
    }

    fun existsByUsername(username: String): Boolean {
        return findByUsername(username).isNotEmpty()
    }

    fun existsByEmail(email: String): Boolean{
        return findByEmail(email).isNotEmpty()
    }

    fun findByEmail(email: String): List<User> {
        return scan(mapOf(EMAIL to email))
    }

    fun findByUsername(username: String): List<User> {
        return scan(mapOf(USERNAME to username))
    }

    private fun scan(keys: Map<String, String>): List<User> {
        return repository.scanItem(TABLE_NAME, keys, User::class.java)
    }
}