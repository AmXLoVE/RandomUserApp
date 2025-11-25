package ru.myapplication.randomuserapp.presentation.usercreate.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
internal fun TopBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .background(color = Color.LightGray)
    ) {
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .padding(8.dp)
                .padding(start = 16.dp)
        ) {
            Icon(
                modifier = Modifier
                    .size(40.dp)
                    .align(alignment = Alignment.Center),
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                contentDescription = "",
            )
        }

        Box(
            modifier = Modifier
                .align(alignment = Alignment.Center)
        ) {
            Text(
                text = "Generate User",
                fontSize = 16.sp,
            )
        }

    }
}