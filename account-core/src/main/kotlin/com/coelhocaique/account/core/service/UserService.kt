package com.coelhocaique.account.core.service

import com.coelhocaique.account.core.domain.User
import com.coelhocaique.account.core.domain.dto.UserDTO
import com.coelhocaique.account.core.domain.exception.UserException.UserExceptionHelper.alreadyRegistered
import com.coelhocaique.account.core.domain.exception.UserException.UserExceptionHelper.notFound
import com.coelhocaique.account.core.domain.mapper.AccountMapper.toDTO
import com.coelhocaique.account.core.domain.mapper.UserMapper.toDocument
import com.coelhocaique.account.core.domain.mapper.UserMapper.toMonoDTO
import com.coelhocaique.account.core.persistance.UserRepository
import com.coelhocaique.account.core.util.PasswordUtils.encodePassword
import com.coelhocaique.account.core.util.PasswordUtils.isValidPassword
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import reactor.core.publisher.Mono.*
import reactor.core.publisher.switchIfEmpty

@Service
class UserService(private val repository: UserRepository,
                  private val accountService: AccountService) {

    fun create(dto: Mono<UserDTO>): Mono<UserDTO> {
        return validate(dto)
                .flatMap { hashPassword(toDocument(it)) }
                .flatMap { repository.insert(it) }
                .flatMap { toMonoDTO(it) }
                .doOnSuccess {
                    accountService.create(toDTO(it.userId!!))
                }
    }

    fun authenticate(user: String, password: String): Mono<UserDTO> {
        return findByUsername(user)
                .switchIfEmpty(findByEmail(user))
                .filter { isValidPassword(it.password, password) }
                .flatMap { toMonoDTO(it) }
                .flatMap {
                    accountService.findByUserId(it.userId!!)
                            .map { itt -> it.copy(accounts = itt) }
                }
                .switchIfEmpty { error(notFound()) }
    }

    private fun validate(dto: Mono<UserDTO>): Mono<UserDTO> {
        return dto.filter {
            !repository.existsByEmail(it.email) &&
                    !repository.existsByUsername(it.username)
        }.switchIfEmpty { error(alreadyRegistered()) }
    }

    private fun extractUser(users: List<User>): Mono<User> {
        val user = users.maxBy { it.creationDate }
        return if (user != null)
            just(user)
        else
            empty()
    }

    private fun hashPassword(user: User): Mono<User> {
        return just(user.copy(password = encodePassword(user.password)))
    }

    private fun findByUsername(username: String): Mono<User> {
        return extractUser(repository.findByUsername(username))
    }

    private fun findByEmail(email: String): Mono<User> {
        return extractUser(repository.findByEmail(email))
    }
}