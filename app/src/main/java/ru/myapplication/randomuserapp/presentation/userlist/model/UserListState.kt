package ru.myapplication.randomuserapp.presentation.userlist.model

internal sealed interface UserListState {

    data object Error : UserListState

    data object Loading : UserListState

    data class Content(
        val userList: List<UserListUserDetail>,
    ) : UserListState
}
