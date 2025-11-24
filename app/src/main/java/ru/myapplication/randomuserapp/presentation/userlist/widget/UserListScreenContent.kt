package ru.myapplication.randomuserapp.presentation.userlist.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.myapplication.randomuserapp.R
import ru.myapplication.randomuserapp.presentation.userlist.model.UserDetails
import ru.myapplication.randomuserapp.presentation.userlist.model.UserListModel
import ru.myapplication.randomuserapp.presentation.userlist.model.UserListState

@Composable
internal fun UserListScreenContent(
    state: UserListState.Content,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        items(state.userListModel.userList.size) { userNumber ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp),
                horizontalArrangement = Arrangement.Center,
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(6.dp)
                        .dropShadow(
                            shape = RoundedCornerShape(15),
                            shadow = Shadow(
                                spread = 1.dp,
                                radius = 32.dp,
                                color = Color.LightGray,
                            )
                        )
                        .clip(RoundedCornerShape(15))
                        .background(
                            color = Color.White,
                        )
                        .border(
                            width = 2.dp,
                            color = Color.LightGray,
                            shape = RoundedCornerShape(15)
                        )

                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .width(120.dp)
                                .padding(8.dp)
                                .clip(RoundedCornerShape(15)),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(R.drawable.ic_launcher_background),
                                contentDescription = "",
                                modifier = Modifier
                                    .fillMaxHeight(),
                                contentScale = ContentScale.Crop,
                            )
                        }

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
                                Text(
                                    text = state.userListModel.userList[userNumber].firstName +
                                            " " + state.userListModel.userList[userNumber].lastName,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis,
                                )
                            }

                            Spacer(
                                modifier = Modifier
                                    .height(12.dp)
                            )

                            Row() {
                                Text(
                                    text = state.userListModel.userList[userNumber].phone
                                )
                            }

                            Spacer(
                                modifier = Modifier
                                    .height(12.dp)
                            )

                            Row() {

                                Image(
                                    painter = painterResource(R.drawable.ic_launcher_background),
                                    contentDescription = "",
                                    modifier = Modifier
                                        .size(18.dp)
                                )

                                Text(
                                    modifier = Modifier
                                        .padding(
                                            start = 4.dp
                                        ),
                                    text = state.userListModel.userList[userNumber].country
                                )
                            }
                        }

                        Box(
                            modifier = Modifier
                                .align(alignment = Alignment.Top)
                        ) {
                            Image(
                                painter = painterResource(R.drawable.ic_launcher_background),
                                contentDescription = "",
                                modifier = Modifier
                                    .padding(12.dp)
                                    .size(20.dp),
                            )
                        }
                    }
                }
            }
        }
    }

    UserAddButton()
}

@Preview(showBackground = true)
@Composable
private fun UserListContentPreview() {
//    AsyncImage(
//        model = viewModel.getUserPostFromIndex(item).image,
//        contentDescription = "",
//        modifier = Modifier
//            .fillMaxSize()
//            .aspectRatio(1f),
//        contentScale = ContentScale.Crop,
//    )

    UserListScreenContent(
        state = UserListState.Content(
            userListModel = UserListModel(
                userList = listOf(
                    UserDetails(
                        id = 1,
                        firstName = "Ivan",
                        lastName = "Ivanov",
                        gender = "male",
                        age = 25,
                        email = "ad@ad",
                        phone = "123456789",
                        picture = "",
                        country = "RU",
                        photoUrl = ""
                    ),
                    UserDetails(
                        id = 1,
                        firstName = "Ivan",
                        lastName = "Ivanov",
                        gender = "male",
                        age = 25,
                        email = "ad@ad",
                        phone = "123456789",
                        picture = "",
                        country = "RU",
                        photoUrl = ""
                    ),
                    UserDetails(
                        id = 1,
                        firstName = "Ivan",
                        lastName = "Ivanov",
                        gender = "male",
                        age = 25,
                        email = "ad@ad",
                        phone = "123456789",
                        picture = "",
                        country = "RU",
                        photoUrl = ""
                    ),
                    UserDetails(
                        id = 1,
                        firstName = "Ivan",
                        lastName = "Ivanov",
                        gender = "male",
                        age = 25,
                        email = "ad@ad",
                        phone = "123456789",
                        picture = "",
                        country = "RU",
                        photoUrl = ""
                    ),
                    UserDetails(
                        id = 1,
                        firstName = "Ivan",
                        lastName = "Ivanov",
                        gender = "male",
                        age = 25,
                        email = "ad@ad",
                        phone = "123456789",
                        picture = "",
                        country = "RU",
                        photoUrl = ""
                    ),
                    UserDetails(
                        id = 1,
                        firstName = "Ivan",
                        lastName = "Ivanov",
                        gender = "male",
                        age = 25,
                        email = "ad@ad",
                        phone = "123456789",
                        picture = "",
                        country = "RU",
                        photoUrl = ""
                    ),
                    UserDetails(
                        id = 1,
                        firstName = "Ivan",
                        lastName = "Ivanov",
                        gender = "male",
                        age = 25,
                        email = "ad@ad",
                        phone = "123456789",
                        picture = "",
                        country = "RU",
                        photoUrl = ""
                    ),
                )
            )
        ),
    )
}