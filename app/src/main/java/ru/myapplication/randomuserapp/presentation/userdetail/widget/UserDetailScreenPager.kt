package ru.myapplication.randomuserapp.presentation.userdetail.widget

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import ru.myapplication.randomuserapp.presentation.userdetail.model.UserDetailEmailInfo
import ru.myapplication.randomuserapp.presentation.userdetail.model.UserDetailLocationInfo
import ru.myapplication.randomuserapp.presentation.userdetail.model.UserDetailModel
import ru.myapplication.randomuserapp.presentation.userdetail.model.UserDetailPersonalInfo
import ru.myapplication.randomuserapp.presentation.userdetail.model.UserDetailPhoneInfo

@Composable
internal fun UserDetailScreenPager(
    userDetails: UserDetailModel,
) {
    val pagerState = rememberPagerState(initialPage = 0) { 4 }

    Box(
        modifier = Modifier
            .padding(8.dp)
    ) {

        //TODO -> pages

        HorizontalPager(
            state = pagerState,
            modifier = Modifier.fillMaxWidth()
        ) { page ->
            when (page) {
                0 -> Text("Имя: ${userDetails.personalInfo.firstName}\nФамилия: " +
                        "${userDetails.personalInfo.lastName}",
                    modifier = Modifier
                        .padding(16.dp),
                )
                1 -> Text("Телефон: ${userDetails.phoneInfo.phoneNumber}\nДомашний: " +
                        "${userDetails.phoneInfo.cellNumber}",
                    modifier = Modifier
                        .padding(16.dp),
                )
                2 -> Text("Email: ${userDetails.emailInfo.email}",
                    modifier = Modifier
                        .padding(16.dp),
                )
                3 -> Text(
                    text = "Город: ${userDetails.locationInfo.city}\n" +
                            "Штат: ${userDetails.locationInfo.state}\n" +
                            "Улица: ${userDetails.locationInfo.street}",
                    modifier = Modifier
                        .padding(16.dp),
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun UserDetailScreenPagerPreview() {
    UserDetailScreenPager(
        userDetails = UserDetailModel(
            personalInfo = UserDetailPersonalInfo(
                firstName = "John",
                lastName = "Doe",
                gender = "",
                age = "",
                birthdate = "",
            ),
            phoneInfo = UserDetailPhoneInfo(
                phoneNumber = "123-456-7890",
                cellNumber = "098-765-4321",
            ),
            emailInfo = UserDetailEmailInfo(
                email = "john.doe@example.com",
                username = "",
            ),
            locationInfo = UserDetailLocationInfo(
                city = "Anytown",
                state = "Anystate",
                street = "123 Main St",
                postcode = "",
                coordinates = "",
            ),
            pictureUrl = "",
        )
    )
}