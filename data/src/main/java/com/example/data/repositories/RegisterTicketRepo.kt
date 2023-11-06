package com.example.data.repositories

import com.example.data.model.RegisterReponse
import com.example.data.model.register.RegisterModel

interface RegisterTicketRepo {
    suspend fun registerTicket(registerModel: RegisterModel): RegisterReponse
}