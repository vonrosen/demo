package com.example.user.controller

import com.example.user.service.LocalUserService
import com.example.user.service.StripePaymentUserService
import com.example.user.validator.addLocalUserRequestDtoValidatorScope
import com.example.user.validator.addPaymentUserRequestDtoValidatorScope
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Put
import io.micronaut.scheduling.TaskExecutors
import io.micronaut.scheduling.annotation.ExecuteOn

@ExecuteOn(TaskExecutors.BLOCKING)
@Controller("/users")
class UserController(
    private val localUserService: LocalUserService,
    private val paymentUserService: StripePaymentUserService
) {

    @Post("/")
    fun addUser(@Body requestDto: AddLocalUserRequestDto): HttpResponse<AddLocalUserResponseDto> {
        with(addLocalUserRequestDtoValidatorScope) {
            if(!requestDto.validate()){
                return HttpResponse.badRequest()
            }
            val newUser = localUserService.createUser(requestDto)
            return HttpResponse.created(
                AddLocalUserResponseDto(
                newUser.name(),
                newUser.email()))
        }
    }

    @Put("/")
    fun addPaymentUser(@Body requestDto: AddPaymentUserRequestDto): HttpResponse<AddPaymentUserResponseDto> {
        with(addPaymentUserRequestDtoValidatorScope) {
            if(!requestDto.validate()){
                return HttpResponse.badRequest()
            }
            val newUser = paymentUserService.createUser(requestDto)
            return HttpResponse.created(
                AddPaymentUserResponseDto(
                newUser.name(),
                newUser.email(),
                newUser.ssn()))
        }
    }

//    @Get("/{id}")
//    fun getUser(@PathVariable id: Long): HttpResponse<LocalUser> {
//        val user = userRepository.findById(id)
//        return if (user.isPresent) {
//            return HttpResponse.ok(user.get())
//        }
//        return HttpResponse.notFound()
//    }
}