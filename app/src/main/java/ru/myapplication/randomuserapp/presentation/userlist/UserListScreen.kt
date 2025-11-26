package ru.myapplication.randomuserapp.presentation.userlist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ru.myapplication.randomuserapp.presentation.LocalNavController
import ru.myapplication.randomuserapp.presentation.common.USER_CREATE_DEST
import ru.myapplication.randomuserapp.presentation.common.USER_DETAIL_DEST
import ru.myapplication.randomuserapp.presentation.userlist.model.UserListUserDetail
import ru.myapplication.randomuserapp.presentation.userlist.model.UserListState
import ru.myapplication.randomuserapp.presentation.userlist.widget.UserListScreenContent
import ru.myapplication.randomuserapp.presentation.userlist.widget.UserListScreenError
import ru.myapplication.randomuserapp.presentation.userlist.widget.UserListScreenLoading

@Composable
internal fun UserListScreen(
    vm: UserListViewModel,
) {
    val state by vm.state.collectAsStateWithLifecycle()
    val nav = LocalNavController.current

    UserListScreenChoice(
        state = state,
        onGetUserDetail = { id ->
            nav.navigate("$USER_DETAIL_DEST/${id}")
        },
        onCreateUser = {
            nav.navigate(USER_CREATE_DEST)
        },
    )
}

@Composable
private fun UserListScreenChoice(
    state: UserListState,
    onGetUserDetail: (Int) -> Unit,
    onCreateUser: () -> Unit,
) {

    Scaffold { paddingValues ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = paddingValues)
        ) {
            when (state) {
                is UserListState.Content -> UserListScreenContent(
                    userList = state.userList,
                    onGetUserDetail = onGetUserDetail,
                    onCreateUser = onCreateUser,
                )

                UserListState.Error -> UserListScreenError(
                    onReloadPage = {}
                )

                UserListState.Loading -> UserListScreenLoading()
            }
        }
    }
}

@Preview
@Composable
private fun UserListScreenContentLoadingPreview() {
    Column(modifier = Modifier.fillMaxSize()) {
        UserListScreenChoice(
            state = UserListState.Loading,
            onGetUserDetail = {},
            onCreateUser = {},
        )
    }
}

@Preview
@Composable
private fun UserListScreenContentErrorPreview() {
    Column(modifier = Modifier.fillMaxSize()) {
        UserListScreenChoice(
            state = UserListState.Error,
            onGetUserDetail = {},
            onCreateUser = {},
        )
    }
}

@Preview
@Composable
private fun UserListScreenContentContentPreview() {
    Column(modifier = Modifier.fillMaxSize()) {
        UserListScreenChoice(
            state = UserListState.Content(
                    userList = listOf(
                        UserListUserDetail(
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
                        UserListUserDetail(
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
                        UserListUserDetail(
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
            ),
            onGetUserDetail = {},
            onCreateUser = {},
        )
    }
}
