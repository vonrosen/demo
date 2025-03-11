package com.example.user.controller

import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class AddPaymentUserRequestDto(val id: Long, val ssn: String)