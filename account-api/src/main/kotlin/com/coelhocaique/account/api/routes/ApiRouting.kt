package com.coelhocaique.account.api.routes

import com.coelhocaique.account.api.handler.UserHandler
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.router

@Component
class ApiRouting {

    @Bean
    fun userRoutes(handler: UserHandler) = router {
        POST("/v1/user", handler::create)
        POST("/v1/user/authenticate", handler::authenticate)
    }

}