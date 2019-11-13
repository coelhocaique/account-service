package com.coelhocaique.account.core.domain

import com.amazonaws.services.dynamodbv2.datamodeling.*
import com.coelhocaique.account.core.domain.converters.LocalDateTimeConverter
import org.springframework.data.annotation.Id
import java.time.LocalDateTime
import java.util.*

@DynamoDBTable(tableName = "user")
data class User (

        @Id @DynamoDBHashKey(attributeName = "user_id")
        @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.S)
        var id: UUID?,

        @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.S)
        @get:DynamoDBRangeKey(attributeName = "creation_date")
        @DynamoDBTypeConverted(converter = LocalDateTimeConverter::class)
        var creationDate: LocalDateTime?,

        @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.S)
        @get:DynamoDBAttribute(attributeName = "username")
        var username: String?,

        @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.S)
        @get:DynamoDBAttribute(attributeName = "first_name")
        var firstName: String?,

        @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.S)
        @get:DynamoDBAttribute(attributeName = "last_name")
        var lastName: String?,

        @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.S)
        @get:DynamoDBAttribute(attributeName = "email")
        var email: String?,

        @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.S)
        @get:DynamoDBAttribute(attributeName = "password")
        var password: String?
){
    constructor() : this(null, null, null, null, null, null, null)
}