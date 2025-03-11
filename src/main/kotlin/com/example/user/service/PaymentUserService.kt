package com.example.user.service

import com.example.user.controller.AddPaymentUserRequestDto
import com.example.user.model.PaymentUser
import com.example.user.validator.ValidatorScope

interface PaymentUserService{

    context(ValidatorScope<AddPaymentUserRequestDto>)
    fun createUser(dto: AddPaymentUserRequestDto): PaymentUser

}