package com.example.user.controller

import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class AddPaymentUserResponseDto(val name: String, val email: String, val ssn: String)