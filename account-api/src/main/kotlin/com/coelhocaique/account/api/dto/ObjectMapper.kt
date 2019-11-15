package com.coelhocaique.account.api.dto

import com.coelhocaique.account.core.domain.dto.UserDTO
import reactor.core.publisher.Mono
import reactor.core.publisher.Mono.just

object ObjectMapper {

    fun toUserDTO(request: UserRequestDTO): Mono<UserDTO> =
            just(UserDTO(
                    userId = request.userId,
                    username = request.username!!,
                    email = request.email!!,
                    firstName = request.firstName!!,
                    lastName = request.lastName!!,
                    password = request.password
            ))


}