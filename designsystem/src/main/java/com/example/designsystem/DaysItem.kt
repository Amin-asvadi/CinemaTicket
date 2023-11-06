package com.example.designsystem

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.designsystem.theme.BROWN
import com.example.designsystem.theme.DarkGrey

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DaysItem(
    modifier: Modifier,
    index: Int,
    day: String,
    dayName: String,
    isSelected: Boolean,
    onClick: (Int) -> Unit
) {
    Card(
        modifier = modifier
            .width(50.dp)
            .height(60.dp),
        border = BorderStroke(width = 1.dp, BROWN.copy(0.5f)),
        shape = RoundedCornerShape(
            16.dp
        ),
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 2.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = if (isSelected) BROWN else Color.White
        ), onClick = { onClick(index) }
    ) {
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = day, color = Color.Black, fontWeight = FontWeight.Bold)
            Text(text = dayName, color = Color.Black, fontSize = 11.sp)
        }

    }
}