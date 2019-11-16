package com.coelhocaique.account.api.handler

import com.coelhocaique.account.api.helper.Messages.INVALID_REQUEST
import com.coelhocaique.account.api.helper.exception.ApiException.ApiExceptionHelper.business
import org.springframework.web.reactive.function.server.ServerRequest
import reactor.core.publisher.Mono

object RequestParameterHandler {

    inline fun <reified T> extractBody(req: ServerRequest): Mono<T> {
        return req.bodyToMono(T::class.java)
                .onErrorMap { business(INVALID_REQUEST, it) }
    }
}