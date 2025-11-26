package ru.myapplication.randomuserapp.presentation.usercreate

import android.util.Log
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
import ru.myapplication.randomuserapp.presentation.common.USER_LIST_DEST
import ru.myapplication.randomuserapp.presentation.usercreate.model.UserCreateData
import ru.myapplication.randomuserapp.presentation.usercreate.model.UserCreateState
import ru.myapplication.randomuserapp.presentation.usercreate.widget.TopBar
import ru.myapplication.randomuserapp.presentation.usercreate.widget.UserCreateScreenContent
import ru.myapplication.randomuserapp.presentation.usercreate.widget.UserCreateScreenError
import ru.myapplication.randomuserapp.presentation.usercreate.widget.UserCreateScreenLoading

@Composable
internal fun UserCreateScreen(
    vm: UserCreateViewModel,
) {
    val state by vm.state.collectAsStateWithLifecycle()
    val nav = LocalNavController.current

    UserCreateScreenChoice(
        state = state,
        onGenerate = {
            vm.generateUser()
            nav.navigate(USER_LIST_DEST)
        },
        onPopStackBack = { nav.navigate(USER_LIST_DEST) },
    )
}

@Composable
private fun UserCreateScreenChoice(
    state: UserCreateState,
    onGenerate: () -> Unit,
    onPopStackBack: () -> Unit,
) {

    Scaffold { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = paddingValues)
        )
        {

            TopBar(
                onPopStackBack = onPopStackBack,
            )

            when (state) {
                is UserCreateState.Content -> UserCreateScreenContent(
                    state = state.userCreateData,
                    onGenerate = onGenerate,
                )

                UserCreateState.Error -> UserCreateScreenError(
                    onReloadPage = {},
                )

                UserCreateState.Loading -> UserCreateScreenLoading()
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun PreviewContent() {
    UserCreateScreenChoice(
        state = UserCreateState.Content(
            UserCreateData(
                genderList = listOf(
                    "Male",
                    "Female",
                ),
                countryList = listOf(
                    "Russian Federation",
                    "United States",
                    "Australia"
                ),
            )
        ),
        onGenerate = {},
        onPopStackBack = {},
    )
}

@Preview(showSystemUi = true)
@Composable
private fun PreviewLoading() {
    UserCreateScreenChoice(
        state = UserCreateState.Loading,
        onGenerate = {},
        onPopStackBack = {},
    )
}

@Preview(showSystemUi = true)
@Composable
private fun PreviewError() {
    UserCreateScreenChoice(
        state = UserCreateState.Error,
        onGenerate = {},
        onPopStackBack = {},
    )
}