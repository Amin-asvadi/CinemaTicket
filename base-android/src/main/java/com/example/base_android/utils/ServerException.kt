package com.example.base_android.utils

class ServerException(
    private val serverMessage: String?,
    val code: Int,
    private val metaCode: String?
) : Exception(
    "Server error $code ($metaCode) $serverMessage"
)
