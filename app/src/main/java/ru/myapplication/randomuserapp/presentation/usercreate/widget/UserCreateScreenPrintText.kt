package ru.myapplication.randomuserapp.presentation.usercreate.widget

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
internal fun PrintText(
    text: String,
) {
    Spacer(
        modifier = Modifier
            .height(12.dp),
    )

    Box(
        modifier = Modifier
            .padding(12.dp),
    ) {
        Text(
            text = text,
            fontSize = 16.sp,
        )
    }
}