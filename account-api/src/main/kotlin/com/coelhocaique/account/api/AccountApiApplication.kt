package com.coelhocaique.account.api

import com.coelhocaique.account.core.AccountCore
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Import
import org.springframework.context.annotation.PropertySource

@SpringBootApplication
@ComponentScan(basePackageClasses = [AccountApiApplication::class])
@Import(AccountCore::class)
@PropertySource(value=["classpath:api-application.properties",
						"classpath:api-application-\${spring.profiles.active}.properties"])
class AccountApiApplication

fun main(args: Array<String>) {
	runApplication<AccountApiApplication>(*args)
}
