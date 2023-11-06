package com.example.designsystem

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import drawMyCustomShape

@Composable
fun TopBarHeader(modifier: Modifier) {
    Image(
        painter = painterResource(id = com.example.common_ui_android.R.drawable.cinema),
        contentDescription = "",
        modifier = modifier
            .fillMaxWidth()
            .height(170.dp)
            .padding(16.dp)
            .drawWithContent {
                drawMyCustomShape()
            }
            .graphicsLayer { this.rotationX = rotationX },
        contentScale = ContentScale.FillWidth
    )
}
