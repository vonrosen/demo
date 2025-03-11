package com.example.user.model

interface LocalUser {
    fun name(): String
    fun email(): String
    fun id() : LocalUserId
}