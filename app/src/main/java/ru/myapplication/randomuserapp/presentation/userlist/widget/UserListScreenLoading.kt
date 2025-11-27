package ru.myapplication.randomuserapp.presentation.userlist.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import ru.myapplication.randomuserapp.presentation.common.shimmerLoading

@Composable
internal fun UserListItemShimmer() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(140.dp),
        horizontalArrangement = Arrangement.Center,
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
                .padding(horizontal = 4.dp)
                .dropShadow(
                    shape = RoundedCornerShape(12.dp),
                    shadow = Shadow(
                        spread = 1.dp,
                        radius = 32.dp,
                        color = Color.LightGray,
                    )
                )
                .clip(RoundedCornerShape(12.dp))
                .background(
                    color = Color.White,
                )
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .size(120.dp)
                        .padding(8.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .shimmerLoading(),
                    contentAlignment = Alignment.Center
                ) {}

                Column(
                    modifier = Modifier
                        .padding(
                            start = 8.dp,
                            end = 8.dp
                        )
                        .weight(1f)
                ) {

                    Row(
                    ) {
                        Box(
                            modifier = Modifier
                                .height(16.dp)
                                .width(60.dp)
                                .clip(RoundedCornerShape(25))
                                .shimmerLoading(),
                            contentAlignment = Alignment.Center
                        ) {}

                        Spacer(
                            modifier = Modifier
                                .width(8.dp)
                        )

                        Box(
                            modifier = Modifier
                                .height(16.dp)
                                .width(100.dp)
                                .clip(RoundedCornerShape(25))
                                .shimmerLoading(),
                            contentAlignment = Alignment.Center
                        ) {}
                    }

                    Spacer(
                        modifier = Modifier
                            .height(12.dp)
                    )

                    Row() {
                        Box(
                            modifier = Modifier
                                .height(16.dp)
                                .width(90.dp)
                                .clip(RoundedCornerShape(25))
                                .shimmerLoading(),
                            contentAlignment = Alignment.Center
                        ) {}
                    }

                    Spacer(
                        modifier = Modifier
                            .height(12.dp)
                    )

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {

                        Box(
                            modifier = Modifier
                                .size(23.dp)
                                .clip(CircleShape)
                                .shimmerLoading()
                        ) {}

                        Spacer(
                            modifier = Modifier
                                .width(4.dp)
                        )

                        Box(
                            modifier = Modifier
                                .height(16.dp)
                                .width(30.dp)
                                .clip(RoundedCornerShape(25))
                                .shimmerLoading(),
                            contentAlignment = Alignment.Center
                        ) {}
                    }
                }

                Box(
                    modifier = Modifier
                        .align(alignment = Alignment.Top)
                ) {
                    Box(
                        modifier = Modifier
                            .padding(12.dp)
                            .size(25.dp)
                            .shimmerLoading(),
                    )
                }
            }
        }
    }
}

@Composable
internal fun UserListScreenLoading() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        repeat(
            times = 3,
        ) {

        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .zIndex(1f)
    ) {

        Button(
            modifier = Modifier
                .align(alignment = Alignment.BottomEnd)
                .padding(28.dp)
                .size(50.dp)
                .clip(RoundedCornerShape(25)),
            shape = RoundedCornerShape(15),
            contentPadding = PaddingValues(0.dp),
            onClick = {},
            enabled = false,
        ) {

            Icon(
                imageVector = Icons.Default.Add,
                tint = Color.White,
                contentDescription = "",
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxSize()
                    .align(Alignment.CenterVertically)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun UserListScreenLoadingPreview() {
    UserListScreenLoading()
}