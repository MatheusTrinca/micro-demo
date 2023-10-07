package com.example.model.request

import com.example.model.Address
import com.example.model.AppUser
import io.micronaut.core.annotation.Introspected
import io.micronaut.serde.annotation.Serdeable.Deserializable
import io.micronaut.serde.annotation.Serdeable.Serializable

@Introspected
@Serializable
@Deserializable
data class AppUserRequest(
    val name: String,
    val email: String,
    val street: String,
    val city: String,
    val code: Int
) {

    fun toModel(): AppUser {
        return AppUser(
            name = this.name,
            email = this.email,
            address = Address(
                street = this.street,
                city = this.city,
                code = this.code
            )
        )
    }

}