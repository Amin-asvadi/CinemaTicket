package com.example.domain.chair

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.base_android.utils.IoDispatcher
import com.example.base_android.utils.ResultUseCase
import com.example.data.model.ChairDataModel
import com.example.data.model.DaysModel
import kotlinx.coroutines.CoroutineDispatcher
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.temporal.TemporalAdjusters
import javax.inject.Inject

class GetDaysUseCase @Inject constructor(
    @IoDispatcher dispatcher: CoroutineDispatcher,
) : ResultUseCase<Unit, List<DaysModel>>(dispatcher) {

    val currentDate = LocalDate.now()
    val firstDayOfWeek = currentDate.with(DayOfWeek.MONDAY)
    val lastDayOfWeek = currentDate.with(DayOfWeek.SUNDAY)

    val daysOfWeek = ArrayList<DaysModel>()
    var currentDay = firstDayOfWeek
    override suspend fun doWork(params: Unit): List<DaysModel> {

        while (!currentDay.isAfter(lastDayOfWeek)) {
            val dayNumber = currentDay.dayOfMonth
            val dayName = if (currentDay == currentDate) "TODAY" else currentDay.format(
                DateTimeFormatter.ofPattern("EEE")
            )
            val dayModel = DaysModel(dayNumber, dayName, false)
            daysOfWeek.add(dayModel)
            currentDay = currentDay.plusDays(1)
        }

        return daysOfWeek
    }


}