package com.example.data.model
import androidx.annotation.Keep
import kotlinx.serialization.Serializable
@Serializable
@Keep
data class RegisterReponse(
    val status: String
)