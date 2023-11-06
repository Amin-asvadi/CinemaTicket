package com.example.designsystem

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.designsystem.theme.Orange

@Composable
fun BuyTicket(modifier: Modifier, tiketSize: String, onSelectBuyItem: () -> Unit) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = modifier, horizontalAlignment = Alignment.Start) {
            Text(
                text = "$${15 * tiketSize.toInt()}",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(
                text = "$tiketSize tickets",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Gray
            )
        }
        OutlinedButton(
            onClick = onSelectBuyItem, colors = ButtonDefaults.buttonColors(
                containerColor = Orange
            ), border = BorderStroke(width = 1.dp, color = Orange)
        ) {
            Text(text = "But Ticket", color = Color.White)
            Spacer(modifier = modifier.width(8.dp))
            Icon(
                painter = painterResource(id = com.example.common_ui_android.R.drawable.ic_ticket),
                contentDescription = "Ticket",
                tint = Color.White
            )
        }

    }
}