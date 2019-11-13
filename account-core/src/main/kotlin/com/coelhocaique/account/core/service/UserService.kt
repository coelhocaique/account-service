package com.coelhocaique.account.core.service

import com.coelhocaique.account.core.persistance.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val repository: UserRepository) {


}