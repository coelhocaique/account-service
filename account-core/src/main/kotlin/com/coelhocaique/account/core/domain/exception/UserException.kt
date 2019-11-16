package com.coelhocaique.account.core.domain.exception

import java.lang.RuntimeException

data class UserException(val type: ExceptionType,
                         val messages: List<String> = listOf(),
                         val ex: Throwable? = null
): RuntimeException(ex) {

    enum class ExceptionType(val status: Int){
        USER_NOT_FOUND(404),
        USER_ALREADY_REGISTERED(400)
    }

    companion object UserExceptionHelper {
        fun notFound() = UserException(ExceptionType.USER_NOT_FOUND, listOf("Invalid credentials."))

        fun alreadyRegistered() = UserException(ExceptionType.USER_ALREADY_REGISTERED, listOf("Username or email already exists."))
    }
}