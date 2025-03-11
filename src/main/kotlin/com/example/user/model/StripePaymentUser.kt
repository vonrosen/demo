package com.example.user.model

class StripePaymentUser(
    val user: User,
    private val stripeConnectedAccount: StripeConnectedAccount
) : PaymentUser {

    override fun name(): String {
        return user.name
    }

    override fun email(): String {
        return user.email
    }

    override fun ssn(): String {
        return stripeConnectedAccount.ssn
    }

    override fun id(): LocalUserId {
        return LocalUserId(user.id!!)
    }

}