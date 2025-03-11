package com.example.user.service

import com.example.user.factory.UserFactory
import com.example.user.validator.ValidatorScope
import com.example.user.controller.AddLocalUserRequestDto
import com.example.user.model.LocalUser
import com.example.user.model.LocalUserId
import com.example.user.model.LocalUserImpl
import com.example.user.repository.UserRepository
import jakarta.inject.Singleton

@Singleton
class LocalUserService(
    private val userFactory: UserFactory,
    private val userRepository: UserRepository
) {

    context(ValidatorScope<AddLocalUserRequestDto>)
    fun createUser(dto: AddLocalUserRequestDto): LocalUser {
        val savedUser = userRepository.save(userFactory.createUser(dto))
        return LocalUserImpl(savedUser.name, savedUser.email, LocalUserId(savedUser.id!!))
    }

}