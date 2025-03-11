package com.example.user.model

@JvmInline
value class StripePaymentUserId(private val id: String) : PaymentUserId {
    override fun id(): String {
        return id;
    }
}
