package com.example.user.validator

import com.example.user.controller.AddLocalUserRequestDto
import com.example.user.controller.AddPaymentUserRequestDto

interface ValidatorScope<T>{
    fun T.validate(): Boolean
}

val addLocalUserRequestDtoValidatorScope = object : ValidatorScope<AddLocalUserRequestDto> {
    override fun AddLocalUserRequestDto.validate(): Boolean {
        return name.isNotEmpty() && email.isNotEmpty()
    }
}

val addPaymentUserRequestDtoValidatorScope = object : ValidatorScope<AddPaymentUserRequestDto> {
    override fun AddPaymentUserRequestDto.validate(): Boolean {
        return ssn.isNotEmpty()
    }
}