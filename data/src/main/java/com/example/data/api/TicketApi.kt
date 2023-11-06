package com.example.data.api

import com.example.data.model.RegisterReponse
import com.example.data.model.register.RegisterModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface TicketApi {
    @POST("v3/d80d097b-9d1f-4d30-8041-fa98e8eeae70")
    suspend fun registerTicket(
        @Body registerMobile: RegisterModel
    ): Response<RegisterReponse>
}