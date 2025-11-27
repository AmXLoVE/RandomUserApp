package ru.myapplication.randomuserapp.presentation.userdetail.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.myapplication.randomuserapp.R
import ru.myapplication.randomuserapp.presentation.theme.DarkBlue
import ru.myapplication.randomuserapp.presentation.userdetail.model.UserDetailEmailInfo
import ru.myapplication.randomuserapp.presentation.userdetail.model.UserDetailLocationInfo
import ru.myapplication.randomuserapp.presentation.userdetail.model.UserDetailPersonalInfo
import ru.myapplication.randomuserapp.presentation.userdetail.model.UserDetailPhoneInfo
import ru.myapplication.randomuserapp.presentation.userdetail.model.UserDetailState

@Composable
internal fun UserDetailScreenContent(
    state: UserDetailState.Content,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.ic_launcher_background),
            contentDescription = null,
            modifier = Modifier
                .offset(y = 95.dp)
                .size(130.dp)
                .clip(CircleShape),
            )

        Column(
            modifier = Modifier.offset(y = 110.dp),
            horizontalAlignment = Alignment.CenterHorizontally
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
            Text(
                modifier = Modifier.padding(4.dp),
                text = state.personalInfo.firstName + " " + state.personalInfo.lastName,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium,
                color = DarkBlue,
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
                    .clip(RoundedCornerShape(16.dp))
                    .background(color = Color.White)
            ) {
                UserDetailScreenPager(state = state)
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun UserDetailScreenContentPreview() {
    UserDetailScreenContent(
        state = UserDetailState.Content(
            personalInfo = UserDetailPersonalInfo(
                firstName = "AJDK",
                lastName = "asdasd",
                gender = "dsfgsdg",
                age = "33",
                birthdate = "asdasdasd",
            ),
            UserDetailPhoneInfo(
                phoneNumber = "666666",
                cellNumber = "777777",
            ),
            UserDetailEmailInfo(
                email = "andrew@krutoy.com",
                username = "andrewkon",
            ),
            UserDetailLocationInfo(
                city = "city",
                state = "state",
                street = "street",
                postcode = "123123",
                coordinates = "60.00.00, 48.00.00",
            ),
            pictureUrl = "",
        )
    )
}



