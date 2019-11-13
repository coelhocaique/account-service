package com.coelhocaique.account.core.domain

import com.amazonaws.services.dynamodbv2.datamodeling.*
import com.coelhocaique.account.core.domain.converters.LocalDateTimeConverter
import com.coelhocaique.account.core.domain.enums.AccountType
import org.springframework.data.annotation.Id
import java.time.LocalDateTime

@DynamoDBTable(tableName = "account")
data class Account (

        @Id @DynamoDBHashKey(attributeName = "account_id")
        @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.S)
        var id: String?,

        @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.S)
        @get:DynamoDBAttribute(attributeName = "user_id")
        var userId: String?,

        @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.S)
        @get:DynamoDBAttribute(attributeName = "type")
        var type: AccountType?,

        @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.S)
        @get:DynamoDBAttribute(attributeName = "creation_date")
        @DynamoDBTypeConverted(converter = LocalDateTimeConverter::class)
        var creationDate: LocalDateTime?
){
    constructor() : this(null, null, null, null)
}