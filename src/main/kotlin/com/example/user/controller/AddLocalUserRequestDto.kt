package com.example.user.controller

import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class AddLocalUserRequestDto(val name: String, val email: String)