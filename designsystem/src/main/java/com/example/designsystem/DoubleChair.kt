package com.example.designsystem

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import com.example.common_ui_android.R
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.data.model.ChairDataModel
import com.example.designsystem.theme.DarkGrey
import com.example.designsystem.theme.LightOrange

@Composable
fun DoubleChair(
    modifier: Modifier = Modifier,
    doubleChair: Pair<ChairDataModel, ChairDataModel>,
    onChairClickEvent: (id: Int) -> Unit
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(R.drawable.seat_belt), contentDescription = null,
            tint = if (doubleChair.first.isSelected && doubleChair.second.isSelected) LightOrange else DarkGrey,
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
                .padding(top = 6.dp),
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            ChairItem(
                doubleChair.first.id,
                doubleChair.first.isSelected,
                onClickEvent = onChairClickEvent
            )
            Spacer(modifier = Modifier.width(4.dp))
            ChairItem(
                doubleChair.second.id,
                doubleChair.second.isSelected,
                onClickEvent = onChairClickEvent
            )
        }
    }
}