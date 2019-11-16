package com.coelhocaique.account.api.handler

import com.coelhocaique.account.api.dto.ObjectMapper.toUserDTO
import com.coelhocaique.account.api.dto.UserRequestDTO
import com.coelhocaique.account.api.handler.RequestParameterHandler.extractBody
import com.coelhocaique.account.api.helper.RequestValidator.validate
import com.coelhocaique.account.api.helper.RequestValidator.validateAuthentication
import com.coelhocaique.account.api.helper.ResponseHandler.generateResponse
import com.coelhocaique.account.core.service.UserService
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Component
class UserHandler (private val service: UserService) {

    fun create(req: ServerRequest): Mono<ServerResponse> {
        val response = extractBody<UserRequestDTO>(req)
                .flatMap { validate(it) }
                .flatMap { service.create(toUserDTO(it)) }

        return generateResponse(response, 201)
    }

    fun authenticate(req: ServerRequest): Mono<ServerResponse> {
        val response = extractBody<UserRequestDTO>(req)
                .flatMap { validateAuthentication(it) }
                .flatMap { service.authenticate(it.user!!, it.password!!) }

        return generateResponse(response, 200)
    }
}