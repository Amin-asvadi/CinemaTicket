package com.example.designsystem

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.designsystem.theme.DarkGrey
import com.example.designsystem.theme.Orange
import kotlinx.coroutines.launch

@Composable
fun BtnComponent(onClick: () -> Unit) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        OutlinedButton(
            onClick = onClick, colors = ButtonDefaults.buttonColors(
                containerColor = Orange
            ),
            border = BorderStroke(1.dp, DarkGrey),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(text = "RESERVE", color = Color.White)
        }
    }
}