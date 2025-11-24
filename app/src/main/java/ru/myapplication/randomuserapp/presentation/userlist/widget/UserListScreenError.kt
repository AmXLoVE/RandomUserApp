package ru.myapplication.randomuserapp.presentation.userlist.widget

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.myapplication.randomuserapp.R

@Composable
internal fun UserListScreenError(
    onReloadPage: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = 32.dp
            ),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .dropShadow(
                    shape = CircleShape,
                    shadow = Shadow(
                        spread = 1.dp,
                        radius = 64.dp,
                        color = Color.LightGray,
                    )
                )
                .clickable { onReloadPage},
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row() {
                Text(
                    text = "Не удалось загрузить содержимое"
                )
            }

            Spacer(
                modifier = Modifier
                    .height(24.dp)
            )

            Icon(
                modifier = Modifier
                    .size(40.dp),
//                    .border(
//                        width = 1.dp,
//                        color = Color.DarkGray,
//                        shape = CircleShape,
//                    )
                painter = painterResource(R.drawable.reload),
                contentDescription = "",
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun UserListScreenErrorPreview() {
    UserListScreenError(
        onReloadPage = {}
    )
}