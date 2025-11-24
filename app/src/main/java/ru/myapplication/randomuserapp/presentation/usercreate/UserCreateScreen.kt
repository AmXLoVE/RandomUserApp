package ru.myapplication.randomuserapp.presentation.usercreate

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ru.myapplication.randomuserapp.presentation.usercreate.model.UserCreateState
import ru.myapplication.randomuserapp.presentation.usercreate.widget.UserCreateScreenError
import ru.myapplication.randomuserapp.presentation.usercreate.widget.UserCreateScreenLoading

@Composable
internal fun UserCreateScreen(
    vm: UserCreateViewModel,
) {
    val state by vm.state.collectAsStateWithLifecycle()

    UserCreateScreenContent(state = state)
}

@Composable
private fun UserCreateScreenContent(
    state: UserCreateState,
) {
    when (state) {
        is UserCreateState.Content -> UserCreateScreenContent(
            state = state,
        )

        UserCreateState.Error -> UserCreateScreenError()

        UserCreateState.Loading -> UserCreateScreenLoading()
    }
}