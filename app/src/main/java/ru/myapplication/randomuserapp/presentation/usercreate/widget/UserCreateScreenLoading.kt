package ru.myapplication.randomuserapp.presentation.usercreate.widget

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.myapplication.randomuserapp.presentation.common.shimmerLoading

@Composable
internal fun UserCreateScreenLoading() {

    PrintText("Select Gender :")

    PrintDisabledButton(
        shimmerWidth = 80.dp,
        shimmerHeight = 24.dp,
    )

    PrintText("Select Nationality :")

    PrintDisabledButton(
        shimmerWidth = 160.dp,
        shimmerHeight = 24.dp,
    )

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 16.dp,
                    vertical = 10.dp,
                )
                .align(alignment = Alignment.BottomCenter),
            shape = RoundedCornerShape(25),
            enabled = false,
            onClick = {},
        ) {
            Text(
                text = "Generate",
                fontSize = 16.sp,
            )
        }
    }
}

@Composable
private fun PrintDisabledButton(
    shimmerWidth: Dp,
    shimmerHeight: Dp,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 12.dp
            )
            .border(
                width = 1.dp,
                color = Color.Black,
                shape = RoundedCornerShape(15)
            ),
    ) {

        Button(
            enabled = false,
            onClick = {},
            shape = RoundedCornerShape(15),
            colors = ButtonColors(
                containerColor = Color.White,
                contentColor = Color.Black,
                disabledContainerColor = Color.White,
                disabledContentColor = Color.Black,
            ),
        ) {
            Box(
                modifier = Modifier
                    .size(
                        width = shimmerWidth,
                        height = shimmerHeight,
                    )
                    .clip(RoundedCornerShape(15))
                    .shimmerLoading()
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun UserCreateScreenLoadingPreview() {
    UserCreateScreenLoading()
}