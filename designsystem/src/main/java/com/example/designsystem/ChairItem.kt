package com.example.designsystem

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.common_ui_android.R
import com.example.designsystem.theme.Orange

@Composable
fun ChairItem(
    id: Int,
    isSelected: Boolean,
    onClickEvent:(id:Int)-> Unit
) {
    Icon(
        painterResource(R.drawable.seat),
        contentDescription = null,
        tint = when {
            isSelected -> Orange
            else -> White
        },
        modifier = Modifier
            .size(36.dp)
            .clickable {
                onClickEvent(id)
            }
    )
}