package ru.myapplication.randomuserapp.presentation.usercreate.widget

import androidx.compose.runtime.Composable
import ru.myapplication.randomuserapp.presentation.userlist.widget.UserListScreenError

@Composable
internal fun UserCreateScreenError(
    onReloadPage: () -> Unit,
) {

    UserListScreenError(
        onReloadPage = onReloadPage
    )
}