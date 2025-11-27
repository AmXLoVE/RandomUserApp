package ru.myapplication.randomuserapp.presentation.userdetail.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.myapplication.randomuserapp.presentation.theme.DarkBlue
import ru.myapplication.randomuserapp.presentation.theme.LightBlue
import ru.myapplication.randomuserapp.presentation.userdetail.model.UserDetailEmailInfo
import ru.myapplication.randomuserapp.presentation.userdetail.model.UserDetailLocationInfo
import ru.myapplication.randomuserapp.presentation.userdetail.model.UserDetailPersonalInfo
import ru.myapplication.randomuserapp.presentation.userdetail.model.UserDetailPhoneInfo
import ru.myapplication.randomuserapp.presentation.userdetail.model.UserDetailState

@Composable
internal fun UserDetailScreenPager(
    state: UserDetailState.Content,
) {
    var selectedTab by remember { mutableIntStateOf(0) }

    val tabs = listOf(
        Icons.Default.Person,
        Icons.Default.Phone,
        Icons.Default.Email,
        Icons.Default.LocationOn)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(LightBlue, DarkBlue),
                    tileMode = TileMode.Decal,
                ),
            ),
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
        ) {
            tabs.forEachIndexed { index, title ->
                Button(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    colors = ButtonDefaults.buttonColors(
                        containerColor =
                            if (selectedTab == index)
                                Color.White
                            else
                                Color.Transparent,
                        contentColor =
                            if (selectedTab == index)
                                Color.Black
                            else
                                Color.White
                    ),
                    shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
                    onClick = { selectedTab = index },
                ) {
                    Icon(
                        imageVector = title,
                        contentDescription = "",
                    )
                }
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    color = Color(0xFFF5F5F5),
                    shape = RoundedCornerShape(bottomStart = 12.dp, bottomEnd = 12.dp)
                )
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                when (selectedTab) {
                    0 -> PersonalInfoTabContent( personalInfo = state.personalInfo)
                    1 -> PhoneInfoTabContent(phoneInfo = state.phoneInfo)
                    2 -> EmailInfoTabContent(emailInfo = state.emailInfo)
                    3 -> LocationInfoTabContent(locationInfo = state.locationInfo)
                }
            }
        }
    }
}

@Composable
private fun PersonalInfoTabContent(
    personalInfo: UserDetailPersonalInfo,
) {
    TabContent(
        title = "First name",
        text = personalInfo.firstName
    )
    TabContent(
        title = "Last name",
        text = personalInfo.lastName
    )
    TabContent(
        title = "Gender",
        text = personalInfo.gender
    )
    TabContent(
        title = "Age",
        text = personalInfo.age
    )
    TabContent(
        title = "Date of bitrh",
        text = personalInfo.birthdate
    )
}

@Composable
private fun PhoneInfoTabContent(
    phoneInfo: UserDetailPhoneInfo,
) {
    TabContent(
        title = "Phone",
        text = phoneInfo.phoneNumber
    )
    TabContent(
        title = "Cell",
        text = phoneInfo.cellNumber
    )
}

@Composable
private fun EmailInfoTabContent(
    emailInfo: UserDetailEmailInfo,
) {
    TabContent(
        title = "E-mail",
        text = emailInfo.email
    )
    TabContent(
        title = "Username",
        text = emailInfo.username
    )
}

@Composable
private fun LocationInfoTabContent(
    locationInfo: UserDetailLocationInfo,
) {
    TabContent(
        title = "City",
        text = locationInfo.city
    )
    TabContent(
        title = "State",
        text = locationInfo.state
    )
    TabContent(
        title = "Street",
        text = locationInfo.street
    )
    TabContent(
        title = "Postcode",
        text = locationInfo.postcode
    )
    TabContent(
        title = "Coordinates",
        text = locationInfo.coordinates
    )
}


@Composable
fun TabContent(
    title: String,
    text: String,
) {
    Row(
        modifier = Modifier
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        Text(
            text = title,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 14.sp,
            color = DarkBlue,
        )

        Text(
            text = ":",
            fontWeight = FontWeight.ExtraBold,
            fontSize = 14.sp,
            color = DarkBlue,
        )

        Text(
            text = text,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            color = DarkBlue,
        )
    }
}

@Preview(showSystemUi = true)
@Composable
private fun UserDetailScreenPagerPreview() {
    UserDetailScreenPager(
        state = UserDetailState.Content(
            personalInfo = UserDetailPersonalInfo(
                firstName = "John",
                lastName = "Doe",
                gender = "Male",
                age = "asd",
                birthdate = "asdfasf",
            ),
            phoneInfo = UserDetailPhoneInfo(
                phoneNumber = "123-456-7890",
                cellNumber = "098-765-4321",
            ),
            emailInfo = UserDetailEmailInfo(
                email = "john.doe@example.com",
                username = "asdfsdf",
            ),
            locationInfo = UserDetailLocationInfo(
                city = "Anytown",
                state = "Anystate",
                street = "123 Main St",
                postcode = "sdfsf",
                coordinates = "sdfsdfsdfsfdsdfsdfsdfsdf",
            ),
            pictureUrl = "",
        )
    )
}