package com.example.ui_main_screen

import androidx.compose.ui.graphics.Color
import com.example.base_android.extention.generate24HourTimeList
import com.example.base_android.utils.AsyncResult
import com.example.base_android.utils.Uninitialized
import com.example.data.model.ChairDataModel
import com.example.data.model.DaysModel
import com.example.data.model.RegisterReponse
import com.example.designsystem.theme.DarkGrey
import com.example.designsystem.theme.Orange

data class MainScreenState(
    val chair: List<ChairDataModel> = emptyList(),
    val daysOfMonth: List<DaysModel> = emptyList(),
    val chairResponseData: AsyncResult<List<ChairDataModel>> = Uninitialized,
    val buyTicketResponse: AsyncResult<RegisterReponse> = Uninitialized,
    val daysResponseData: AsyncResult<List<DaysModel>> = Uninitialized,
    val leftChair: List<Int> = listOf(0, 3, 6, 9, 12),
    val rightChair: List<Int> = listOf(2, 5, 8, 11, 14),
    val isSelectedDay: Int = -1,
    val isSelectedTime: Int = -1,
    val info: List<Pair<Color, String>> = listOf(
        Pair(Orange, "Selected"),
        Pair(Color.White, "Available"),
        Pair(DarkGrey, "Reserved")
    ),
    val timeList: MutableList<String> = mutableListOf()
) {
    val pairChair: List<Pair<ChairDataModel, ChairDataModel>> =
        chair.chunked(2).map { it.first() to it.last() }
    val hoursList = timeList.generate24HourTimeList()
}
