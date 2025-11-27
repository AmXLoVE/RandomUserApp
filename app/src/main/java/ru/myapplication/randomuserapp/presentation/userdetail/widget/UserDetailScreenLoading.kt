package ru.myapplication.randomuserapp.presentation.userdetail.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.unit.dp
import ru.myapplication.randomuserapp.presentation.common.shimmerLoading

@Composable
internal fun UserDetailScreenLoading() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = Modifier
                .offset(y = 95.dp)
                .size(130.dp)
                .clip(CircleShape)
                .background(color = Color.White)
                .shimmerLoading(),
        )

        Column(
            modifier = Modifier.offset(y = 110.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Text(
                modifier = Modifier.padding(4.dp),
                text = "Hi how are you today?",
                color = Color.Gray,
            )

            Text(
                modifier = Modifier.padding(4.dp),
                text = "I'm",
                color = Color.Gray,
            )

            Box(
                modifier = Modifier
                    .padding(4.dp)
                    .size(
                        width = 140.dp,
                        height = 20.dp,
                    )
                    .shimmerLoading(),
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(500.dp)
                    .padding(
                        horizontal = 20.dp,
                        vertical = 32.dp,
                    )
                    .dropShadow(
                        shape = RoundedCornerShape(5),
                        shadow = Shadow(
                            color = Color.Gray.copy(alpha = 0.8f),
                            radius = 16.dp,
                            spread = 4.dp,
                        )
                    )
                    .clip(RoundedCornerShape(5))
                    .background(color = Color.White),
            ) {
                Column(modifier = Modifier.padding(8.dp)) {
                    Spacer(modifier = Modifier.height(12.dp))

                    Box(
                        modifier = Modifier
                            .padding(12.dp)
                            .size(
                                width = 140.dp,
                                height = 20.dp,
                            )
                            .shimmerLoading()
                    )

                    Box(
                        modifier = Modifier
                            .padding(12.dp)
                            .size(
                                width = 140.dp,
                                height = 20.dp,
                            )
                            .shimmerLoading(),
                    )

                    Box(
                        modifier = Modifier
                            .padding(12.dp)
                            .size(
                                width = 140.dp,
                                height = 20.dp,
                            )
                            .shimmerLoading(),
                    )
                }
            }
        }
    }
}