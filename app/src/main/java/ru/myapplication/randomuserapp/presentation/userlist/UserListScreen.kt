package ru.myapplication.randomuserapp.presentation.userlist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ru.myapplication.randomuserapp.presentation.userlist.model.UserListModel
import ru.myapplication.randomuserapp.presentation.userlist.model.UserListState
import ru.myapplication.randomuserapp.presentation.userlist.widget.UserListContent
import ru.myapplication.randomuserapp.presentation.userlist.widget.UserListError
import ru.myapplication.randomuserapp.presentation.userlist.widget.UserListLoading

@Composable
internal fun UserListScreen(
    vm: UserListViewModel,
) {
    val state by vm.state.collectAsStateWithLifecycle()

    UserListScreenContent(state = state)
}

@Composable
private fun UserListScreenContent(
    state: UserListState,
) {
    when (state) {
        is UserListState.Content -> UserListContent(
            state = state,
        )

        UserListState.Error -> UserListError()

        UserListState.Loading -> UserListLoading()
    }
}

@Preview
@Composable
private fun UserListScreenContentLoadingPreview() {
    Column(modifier = Modifier.fillMaxSize()) {
        UserListScreenContent(
            state = UserListState.Loading,
        )
    }
}

@Preview
@Composable
private fun UserListScreenContentErrorPreview() {
    Column(modifier = Modifier.fillMaxSize()) {
        UserListScreenContent(
            state = UserListState.Error,
        )
    }
}

@Preview
@Composable
private fun UserListScreenContentContentPreview() {
    Column(modifier = Modifier.fillMaxSize()) {
        UserListScreenContent(
            state = UserListState.Content(
                userListModel = UserListModel(userList = emptyList())
            ),
        )
    }
}
