package com.example.controller

import com.example.model.User
import com.example.repository.UserRepository
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import io.micronaut.scheduling.TaskExecutors
import io.micronaut.scheduling.annotation.ExecuteOn

@ExecuteOn(TaskExecutors.BLOCKING)
@Controller("/users")
class UserController(private val userRepository: UserRepository) {

    @Post("/")
    fun addUser(@Body user: User): HttpResponse<User> {
        val newUser = userRepository.save(user)
        return HttpResponse.created(newUser)
    }

    @Get("/{id}")
    fun getUser(@PathVariable id: Long): HttpResponse<User> {
        val user = userRepository.findById(id)
        return if (user.isPresent) {
            HttpResponse.ok(user.get())
        } else {
            HttpResponse.notFound()
        }
    }

    @Put("/{id}")
    fun updateUser(@PathVariable id: Long, @Body user: User): HttpResponse<User> {
        return if (userRepository.findById(id).isPresent) {
            val updatedUser = user.copy(id = id)
            userRepository.update(updatedUser)
            HttpResponse.ok(updatedUser)
        } else {
            HttpResponse.notFound()
        }
    }

    @Delete("/{id}")
    fun deleteUser(@PathVariable id: Long): HttpResponse<Void> {
        return if (userRepository.findById(id).isPresent) {
            userRepository.deleteById(id)
            HttpResponse.noContent()
        } else {
            HttpResponse.notFound()
        }
    }
}