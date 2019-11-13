package com.coelhocaique.account.core.persistance

import com.coelhocaique.account.core.domain.Account
import org.socialsignin.spring.data.dynamodb.repository.DynamoDBCrudRepository
import org.socialsignin.spring.data.dynamodb.repository.EnableScan

@EnableScan
interface AccountRepository: DynamoDBCrudRepository<Account, String> {

}