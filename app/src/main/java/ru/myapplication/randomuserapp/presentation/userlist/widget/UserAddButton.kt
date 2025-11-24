package ru.myapplication.randomuserapp.presentation.userlist.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex

@Composable
internal fun UserAddButton(
    bgColor: Color = Color.hsv(
        hue = 259f,
        saturation = .8f,
        value = .4f,
        alpha = 1f),
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .zIndex(1f)
    ) {

        Box(
            modifier = Modifier
                .align(alignment = Alignment.BottomEnd)
                .padding(28.dp)
                .size(50.dp)
                .clip(RoundedCornerShape(25))
                .background(color = bgColor)
                .clickable {},
        ) {

            Icon(
                imageVector = Icons.Default.Add,
                tint = Color.White,
                contentDescription = "",
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxSize()
                    .align(Alignment.Center)
            )
        }
    }
}