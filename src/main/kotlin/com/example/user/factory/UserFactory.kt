package com.example.user.factory

import com.example.user.controller.AddLocalUserRequestDto
import com.example.user.model.User
import com.example.user.validator.ValidatorScope
import jakarta.inject.Singleton

@Singleton
class UserFactory {

    context(ValidatorScope<AddLocalUserRequestDto>)
    fun createUser(dto: AddLocalUserRequestDto): User {
        return User(null, dto.name, dto.email)
    }
}