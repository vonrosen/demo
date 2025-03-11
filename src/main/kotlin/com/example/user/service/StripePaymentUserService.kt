package com.example.user.service

import com.example.common.client.StripeClient
import com.example.user.controller.AddPaymentUserRequestDto
import com.example.user.model.PaymentUser
import com.example.user.model.StripePaymentUser
import com.example.user.repository.UserRepository
import com.example.user.validator.ValidatorScope
import jakarta.inject.Singleton

@Singleton
class StripePaymentUserService(
    private val stripeClient: StripeClient,
    private val userRepository: UserRepository
) : PaymentUserService {

    context(ValidatorScope<AddPaymentUserRequestDto>)
    override fun createUser(dto: AddPaymentUserRequestDto): PaymentUser {
        val user = userRepository.findById(dto.id).orElseThrow()
        val connectedAccount = stripeClient.createConnectedAccount(user.name, user.email, dto.ssn)
        user.paymentAccountId = connectedAccount.id
        userRepository.update(user)
        return StripePaymentUser(user, connectedAccount)
    }
}