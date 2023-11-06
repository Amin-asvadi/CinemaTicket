package com.example.domain.chair

import com.example.base_android.utils.IoDispatcher
import com.example.base_android.utils.ResultUseCase
import com.example.data.model.ChairDataModel
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetChairUseCase @Inject constructor(
    @IoDispatcher dispatcher: CoroutineDispatcher,
) : ResultUseCase<Unit, List<ChairDataModel>>(dispatcher) {
    private val chair = mutableListOf<ChairDataModel>()

    override suspend fun doWork(params: Unit): List<ChairDataModel> {
        mockChair()
        return chair
    }

    fun mockChair() {
        for (i in 1..30) {
            chair.add(
                ChairDataModel(
                    id = i,
                    isSelected = false
                )
            )
        }
    }


}