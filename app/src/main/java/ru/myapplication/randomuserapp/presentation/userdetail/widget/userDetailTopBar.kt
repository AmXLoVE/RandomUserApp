package ru.myapplication.randomuserapp.presentation.userdetail.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import ru.myapplication.randomuserapp.presentation.theme.DarkBlue
import ru.myapplication.randomuserapp.presentation.theme.LightBlue

@Composable
internal fun TopBar(
    onPopStackBack: () -> Unit,
) {
    Box(
        modifier = Modifier
            .zIndex(1f)
            .size(60.dp)
            .padding(15.dp)
            .clip(CircleShape)
            .background(Color.White)
            .clickable(
                onClick = onPopStackBack,
            ),
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            modifier = Modifier
                .fillMaxSize()
                .alpha(0.7f),
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
            contentDescription = "",
        )
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp)
            .zIndex(0f)
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        LightBlue,
                        DarkBlue,
                    ),
                    tileMode = TileMode.Decal,
                ),
            ),
    ) {

    }
}