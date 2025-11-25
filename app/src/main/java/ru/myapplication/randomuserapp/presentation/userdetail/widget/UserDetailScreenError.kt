package ru.myapplication.randomuserapp.presentation.userdetail.widget

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.myapplication.randomuserapp.presentation.userlist.widget.UserListScreenError

@Composable
internal fun UserDetailScreenError(
    onReloadPage: () -> Unit,
) {
    Box(
        modifier = Modifier
            .offset(
                y = 180.dp,
            )
    ) {

        UserListScreenError(
            onReloadPage = onReloadPage
        )
    }
}