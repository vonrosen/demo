package com.example.repository

import com.example.model.User
import io.micronaut.data.annotation.Id
import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.model.query.builder.sql.Dialect
import io.micronaut.data.repository.PageableRepository
import jakarta.validation.constraints.NotBlank

@JdbcRepository(dialect = Dialect.MYSQL)
abstract class UserRepository : PageableRepository<User, Long> {

    abstract fun save(
        @NotBlank name: String,
        @NotBlank email: String) : User

    abstract fun update(
        @Id id: Long,
        @NotBlank name: String,
        @NotBlank email: String) : Long
}