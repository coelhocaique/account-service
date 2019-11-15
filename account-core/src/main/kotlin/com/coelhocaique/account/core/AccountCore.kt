package com.coelhocaique.account.core

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource

@Configuration
@ComponentScan(basePackageClasses = [AccountCore::class])
@PropertySource(value=["classpath:core-application.properties"])
class AccountCore