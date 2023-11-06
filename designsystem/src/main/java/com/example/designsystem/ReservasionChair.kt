package com.example.designsystem

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.dp
import com.example.data.model.ChairDataModel

@Composable
fun ReservationChair(
    leftIndex: List<Int>,
    rightIndex: List<Int>,
    chairList: List<Pair<ChairDataModel, ChairDataModel>>,
    onClickEvent: (id: Int) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(0.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        itemsIndexed(chairList) { index, item ->
            when (index) {
                in leftIndex -> DoubleChair(
                    modifier = Modifier.rotate(10f),
                    chairList[index],
                    onChairClickEvent = onClickEvent
                )

                in rightIndex -> DoubleChair(
                    modifier = Modifier.rotate(-10f),
                    chairList[index],
                    onChairClickEvent = onClickEvent
                )

                else -> DoubleChair(
                    modifier = Modifier.padding(top = 9.dp),
                    chairList[index],
                    onChairClickEvent = onClickEvent
                )
            }
        }
    }
}