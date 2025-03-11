package com.example.controller

import com.example.user.model.User
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

@MicronautTest
class UserControllerTest {

    @Inject
    @field:Client("/")
    lateinit var client: HttpClient

    @Test
    fun testAddUser() {
        val user = User(null, "John Doexx", "john.doexx@example.com")
        val request = HttpRequest.POST("/users", user)
        val response: HttpResponse<User> = client.toBlocking().exchange(request, User::class.java)

        assertEquals(HttpResponse.created<User>(user).status, response.status)
        assertNotNull(response.body())
        assertEquals("John Doexx", response.body()!!.name)
    }
}