package com.example.user.model

interface PaymentUser{
    fun name(): String
    fun email(): String
    fun ssn(): String
    fun id() : LocalUserId
}
