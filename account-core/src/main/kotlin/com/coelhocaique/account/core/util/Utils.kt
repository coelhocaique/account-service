package com.coelhocaique.account.core.util

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.time.LocalDate

fun <T : Any> T.logger(): Logger = LoggerFactory.getLogger(javaClass)