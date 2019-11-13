package com.coelhocaique.account.core

import com.coelhocaique.account.core.persistance.AccountRepository
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource

@Configuration
@ComponentScan(basePackageClasses = [AccountCore::class])
@PropertySource(value=["classpath:core-application.properties"])
@EnableDynamoDBRepositories(basePackageClasses = [AccountRepository::class])
class AccountCore