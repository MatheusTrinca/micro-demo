package com.example.model.request

import io.micronaut.core.annotation.Introspected
import io.micronaut.serde.annotation.Serdeable.Deserializable
import io.micronaut.serde.annotation.Serdeable.Serializable

@Introspected
@Serializable
@Deserializable
data class SearchRequest(
    val name: String? = null,
    val email: String? = null
)
