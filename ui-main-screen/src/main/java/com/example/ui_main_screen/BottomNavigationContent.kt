package com.example.ui_main_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.base_android.utils.Loading
import com.example.designsystem.BuyTicket
import com.example.designsystem.DaysItem
import com.example.designsystem.TimeItem
import com.example.designsystem.theme.BROWN

@Composable
fun BottomNavigationContent(
    modifier: Modifier,
    viewState: MainScreenState,
    buyItemClick: () -> Unit,
    onTimeClickEvent: (Int) -> Unit,
    selectedItem: (Int) -> Unit
) {
    var isSelectedItem by remember {
        mutableIntStateOf(-1)
    }
    var isSelectedTime by remember {
        mutableIntStateOf(-1)
    }
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(horizontal = 8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(
            topStart = 16.dp,
            topEnd = 16.dp,
            bottomEnd = 38.dp,
            bottomStart = 38.dp
        ),
        border = BorderStroke(width = 1.dp, BROWN.copy(0.5f))
    ) {
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(end = 24.dp, start = 24.dp, top = 16.dp, bottom = 0.dp),
            content = {
                itemsIndexed(viewState.daysOfMonth) { index, item ->
                    DaysItem(
                        modifier = modifier,
                        day = item.dayNumber.toString(),
                        dayName = item.dayName,
                        isSelected = isSelectedItem == index,
                        index = index,
                        onClick = {
                            isSelectedItem = it
                            selectedItem(it)
                        }
                    )
                }
            })
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            contentPadding = PaddingValues(horizontal = 24.dp, vertical = 16.dp),
            content = {
                itemsIndexed(viewState.hoursList) { index, item ->
                    TimeItem(
                        modifier = modifier,
                        time = item,
                        isSelected = isSelectedItem == index,
                        index = index,
                        onClick = {
                            isSelectedTime = it
                            onTimeClickEvent(it)
                        }
                    )
                }
            })
        BuyTicket(
            modifier = modifier,
            isEnable = viewState.buyTicketResponse !is Loading,
            viewState.chair.filter { it.isSelected }.size.toString()
        ) {
            buyItemClick()
        }
    }
}