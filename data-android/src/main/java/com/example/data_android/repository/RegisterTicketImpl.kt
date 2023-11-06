package com.example.data_android.repository

import com.example.base_android.utils.bodyOrThrow
import com.example.data.api.TicketApi
import com.example.data.model.RegisterReponse
import com.example.data.model.register.RegisterModel
import com.example.data.repositories.RegisterTicketRepo
import javax.inject.Inject

class RegisterTicketImpl @Inject constructor(
    private val api: TicketApi
) : RegisterTicketRepo {
    override suspend fun registerTicket(registerModel: RegisterModel): RegisterReponse {
        return api.registerTicket(registerModel).bodyOrThrow()
    }
}