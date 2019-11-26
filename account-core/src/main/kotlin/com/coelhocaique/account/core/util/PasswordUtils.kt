package com.coelhocaique.account.core.util

import java.security.SecureRandom
import java.util.*
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.PBEKeySpec

object PasswordUtils {

    private const val ITERATIONS = 65536
    private const val KEY_LENGTH = 512
    private const val ALGORITHM = "PBKDF2WithHmacSHA512"
    private const val SALT_LENGTH = 10

    fun encodePassword(password: String): String {
        return hashPassword(password, generateSalt())
    }

    fun isValidPassword(password: String, input: String): Boolean {
        val salt = password.split(":")[1]
        return hashPassword(input, salt) == password
    }

    private fun hashPassword(password: String, salt: String): String {
        val chars = password.toCharArray()
        val spec = PBEKeySpec(chars, salt.toByteArray(), ITERATIONS, KEY_LENGTH)
        Arrays.fill(chars, Character.MIN_VALUE)

        return try {
            val fac = SecretKeyFactory.getInstance(ALGORITHM)
            val securePassword = fac.generateSecret(spec).encoded
            encodeBase64(securePassword).plus(":").plus(salt)
        } catch (e: Exception) {
            throw RuntimeException(e.message, e)
        } finally {
            spec.clearPassword()
        }
    }

    private fun generateSalt(): String {
        val random = SecureRandom.getInstance("SHA1PRNG")
        val salt = ByteArray(SALT_LENGTH)
        random.nextBytes(salt)
        return encodeBase64(salt)
    }

    private fun encodeBase64(array: ByteArray) = Base64.getEncoder().encodeToString(array)
}