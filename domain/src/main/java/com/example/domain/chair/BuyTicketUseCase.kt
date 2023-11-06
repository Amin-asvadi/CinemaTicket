package com.example.domain.chair

import com.example.base_android.utils.IoDispatcher
import com.example.base_android.utils.ResultUseCase
import com.example.data.model.RegisterReponse
import com.example.data.model.register.RegisterModel
import com.example.data.repositories.RegisterTicketRepo
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class BuyTicketUseCase @Inject constructor(
    @IoDispatcher dispatcher: CoroutineDispatcher,
    val repo: RegisterTicketRepo
) : ResultUseCase<BuyTicketUseCase.Param, RegisterReponse>(dispatcher) {
    override suspend fun doWork(params: Param): RegisterReponse {
        return repo.registerTicket(
            RegisterModel(
                seat_id = params.seat_id, hour = params.hour, day = params.day
            )
        )
    }

    data class Param(val seat_id: String, val hour: String, val day: String)


}