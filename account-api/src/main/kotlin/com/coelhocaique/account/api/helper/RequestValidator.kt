package com.coelhocaique.account.api.helper

import com.coelhocaique.account.api.dto.UserRequestDTO
import com.coelhocaique.account.api.helper.Fields.EMAIL
import com.coelhocaique.account.api.helper.Fields.FIRST_NAME
import com.coelhocaique.account.api.helper.Fields.LAST_NAME
import com.coelhocaique.account.api.helper.Fields.PASSWORD
import com.coelhocaique.account.api.helper.Fields.USER
import com.coelhocaique.account.api.helper.Fields.USERNAME
import com.coelhocaique.account.api.helper.Messages.NOT_NULL
import com.coelhocaique.account.api.helper.exception.ApiException.ApiExceptionHelper.business
import reactor.core.publisher.Mono

object RequestValidator {

    fun validate(dto: UserRequestDTO): Mono<UserRequestDTO> {
        return try {
            nonNull(dto.username, USERNAME)
            nonNull(dto.email, EMAIL)
            nonNull(dto.password, PASSWORD)
            nonNull(dto.firstName, FIRST_NAME)
            nonNull(dto.lastName, LAST_NAME)
            Mono.just(dto)
        } catch (e: IllegalArgumentException){
            Mono.error(business(e.message!!))
        }
    }

    fun validateAuthentication(dto: UserRequestDTO): Mono<UserRequestDTO> {
        return try {
            nonNull(dto.user, USER)
            nonNull(dto.password, PASSWORD)
            Mono.just(dto)
        } catch (e: IllegalArgumentException){
            Mono.error(business(e.message!!))
        }
    }

    private fun nonNull(o: Any?, attr: String) = requireNotNull(o, { NOT_NULL.format(attr)})

}