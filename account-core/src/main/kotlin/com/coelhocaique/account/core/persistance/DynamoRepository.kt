package com.coelhocaique.account.core.persistance

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB
import com.amazonaws.services.dynamodbv2.model.AttributeValue
import com.amazonaws.services.dynamodbv2.model.DeleteItemRequest
import com.amazonaws.services.dynamodbv2.model.GetItemRequest
import com.amazonaws.services.dynamodbv2.model.ScanRequest
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.stereotype.Component

@Suppress("UNCHECKED_CAST")
@Component
class DynamoRepository(val db: AmazonDynamoDB,
                       val objectMapper: ObjectMapper) {

    fun getItem(tableName: String, key: Map<String, String>): Map<String, String> {
        val request = GetItemRequest()
                .withTableName(tableName)
                .withKey(convertToDb(key))
        return convertToMap(db.getItem(request).item)
    }

    fun <T> scanItem(tableName: String, key: Map<String, String>, clazz: Class<T>): List<T> {
        val request = ScanRequest(tableName)
                .withFilterExpression(buildFilterExpression(key))
                .withExpressionAttributeValues(buildExpressionAttributeValues(key))

        return convertToMap(db.scan(request).items, clazz)
    }

    fun <T> addItem(tableName: String, o: T){
        db.putItem(tableName, convertToDb(writeKeys(o)))
    }

    fun <T> deleteItem(tableName: String, key: Map<String, String>): Map<String, String> {
        val request = DeleteItemRequest().withTableName(tableName).withKey(convertToDb(key))
        return convertToMap(db.deleteItem(request).attributes)
    }

    private fun convertToDb(map: Map<String, String>): Map<String, AttributeValue> {
        return map.map { it.key to AttributeValue(it.value) }.toMap()
    }

    private fun <T> convertToMap(attrs: List<Map<String, AttributeValue>>, o: Class<T>): List<T> {
        return attrs.map { readKeys(convertToMap(it), o) }
    }

    private fun convertToMap(map: Map<String, AttributeValue>): Map<String, String> {
        return map.map { it.key to it.value.s }.toMap()
    }

    private fun buildFilterExpression(filter: Map<String, String>): String {
        return filter.keys.joinToString(" AND ") { it.plus(" = :").plus(it) }
    }

    private fun buildExpressionAttributeValues(filter: Map<String, String>): Map<String, AttributeValue> {
        return filter.map { ":".plus(it.key) to AttributeValue(it.value) }.toMap()
    }

    private fun <T> writeKeys(o: T) =
            objectMapper.readValue(objectMapper.writeValueAsString(o), Map::class.java) as Map<String, String>

    private fun <T> readKeys(json: Map<String, String>, o: Class<T>) =
            objectMapper.readValue(objectMapper.writeValueAsString(json), o)

}