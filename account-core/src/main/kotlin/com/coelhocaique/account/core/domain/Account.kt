package com.coelhocaique.account.core.domain

import com.amazonaws.services.dynamodbv2.datamodeling.*
import com.coelhocaique.account.core.domain.converters.LocalDateConverter
import com.coelhocaique.account.core.domain.converters.LocalDateTimeConverter
import org.springframework.data.annotation.Id
import java.time.LocalDate
import java.time.LocalDateTime

@DynamoDBTable(tableName = "income")
data class Account (

        @Id @DynamoDBHashKey(attributeName = "income_id")
        @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.S)
        var id: String?,

        @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.S)
        @get:DynamoDBAttribute(attributeName = "gross_amount")
        var grossAmount: String?,

        @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.S)
        @get:DynamoDBAttribute(attributeName = "net_amount")
        var netAmount: String?,

        @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.S)
        @get:DynamoDBAttribute(attributeName = "description")
        var description: String?,

        @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.S)
        @get:DynamoDBAttribute(attributeName = "receipt_date")
        @DynamoDBTypeConverted(converter = com.coelhocaique.account.core.domain.converters.LocalDateConverter::class)
        var receiptDate: LocalDate?,

        @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.S)
        @get:DynamoDBAttribute(attributeName = "reference_date")
        var referenceDate: String?,

        @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.S)
        @get:DynamoDBAttribute(attributeName = "source_name")
        var sourceName: String?,

        @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.S)
        @get:DynamoDBAttribute(attributeName = "additional_amount")
        var additionalAmount: String?,

        @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.S)
        @get:DynamoDBAttribute(attributeName = "discount_amount")
        var discountAmount: String?,

        @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.L)
        @get:DynamoDBAttribute(attributeName = "discounts")
        var discounts: List<Map<String, String>>?,

        @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.L)
        @get:DynamoDBAttribute(attributeName = "additions")
        var additions: List<Map<String, String>>?,

        @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.S)
        @get:DynamoDBAttribute(attributeName = "account_id")
        var accountId: String?,

        @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.S)
        @get:DynamoDBAttribute(attributeName = "creation_date")
        @DynamoDBTypeConverted(converter = com.coelhocaique.account.core.domain.converters.LocalDateTimeConverter::class)
        var creationDate: LocalDateTime?
){
    constructor() : this(null, null, null, null, null, null, null, null, null, null, null, null, null)
}