package com.example.common.client

import com.example.user.model.StripeConnectedAccount
import io.micronaut.http.client.HttpClient
import jakarta.inject.Singleton
import java.util.*

@Singleton
class StripeClient(private val httpClient: HttpClient) {

    fun createConnectedAccount(name: String, email: String, ssn: String): StripeConnectedAccount {
//        val request = HttpRequest.POST("/v1/accounts", mapOf(
//            "name" to name,
//            "email" to email,
//            "ssn" to ssn
//        ))
//        val response = httpClient.toBlocking().exchange(request, StripeConnectedAccount::class.java)
//        return response.body()
        return StripeConnectedAccount(UUID.randomUUID().toString(), "ssn")
    }

}