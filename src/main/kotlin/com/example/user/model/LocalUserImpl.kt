package com.example.user.model

data class LocalUserImpl(val name: String, val email: String, val id: LocalUserId) : LocalUser {
    override fun name(): String {
        return name
    }

    override fun email(): String {
        return email
    }

    override fun id(): LocalUserId {
        return id
    }
}