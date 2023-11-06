package com.example.data.model.register

import androidx.annotation.Keep
import kotlinx.serialization.Serializable

@Serializable
@Keep
data class RegisterModel(
    val seat_id: String,
    val hour: String,
    val day: String
)
