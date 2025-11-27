package ru.myapplication.randomuserapp.presentation.userdetail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ru.myapplication.randomuserapp.presentation.LocalNavController
import ru.myapplication.randomuserapp.presentation.userdetail.model.UserDetailEmailInfo
import ru.myapplication.randomuserapp.presentation.userdetail.model.UserDetailLocationInfo
import ru.myapplication.randomuserapp.presentation.userdetail.model.UserDetailPersonalInfo
import ru.myapplication.randomuserapp.presentation.userdetail.model.UserDetailPhoneInfo
import ru.myapplication.randomuserapp.presentation.userdetail.model.UserDetailState
import ru.myapplication.randomuserapp.presentation.userdetail.widget.TopBar
import ru.myapplication.randomuserapp.presentation.userdetail.widget.UserDetailScreenContent
import ru.myapplication.randomuserapp.presentation.userdetail.widget.UserDetailScreenError
import ru.myapplication.randomuserapp.presentation.userdetail.widget.UserDetailScreenLoading

@Composable
internal fun UserDetailScreen(
    vm: UserDetailViewModel,
) {
    val state by vm.state.collectAsStateWithLifecycle()
    val nav = LocalNavController.current

    UserDetailScreenChoice(
        state = state,
        onReloadClick = vm::onReloadClick,
        onPopStackBack = { nav.popBackStack() },
    )
}

@Composable
private fun UserDetailScreenChoice(
    state: UserDetailState,
    onReloadClick: () -> Unit,
    onPopStackBack: () -> Unit,
) {
    Scaffold { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = paddingValues),
        ) {
            TopBar(
                onPopStackBack = onPopStackBack,
            )

            when (state) {
                is UserDetailState.Content -> UserDetailScreenContent(state = state)

                UserDetailState.Error -> UserDetailScreenError(onReloadPage = onReloadClick)

                UserDetailState.Loading -> UserDetailScreenLoading()
            }
        }

    }
}

@Preview(showSystemUi = true)
@Composable
private fun UserDetailScreenErrorPreview() {
    UserDetailScreenChoice(
        state = UserDetailState.Error,
        onReloadClick = {},
        onPopStackBack = {},
    )
}

@Preview(showSystemUi = true)
@Composable
private fun UserDetailScreenLoadingPreview() {
    UserDetailScreenChoice(
        state = UserDetailState.Loading,
        onReloadClick = {},
        onPopStackBack = {},
    )
}

@Preview(showSystemUi = true)
@Composable
private fun UserDetailScreenContentPreview() {
    UserDetailScreenChoice(
        state = UserDetailState.Content(
            personalInfo = UserDetailPersonalInfo(
                firstName = "sdfsdf",
                lastName = "sdfsdf",
                gender = "sdfsdf",
                age = "sdfsdf",
                birthdate = "sdfsdf",
            ),
            UserDetailPhoneInfo(
                phoneNumber = "asda",
                cellNumber = "asd",
            ),
            UserDetailEmailInfo(
                email = "dfbfb",
                username = "cvbcvb",
            ),
            UserDetailLocationInfo(
                city = "hmnhm",
                state = "ghmgmh",
                street = "hmhmh",
                postcode = "hmhmhm",
                coordinates = "hmhmh",
            ),
            pictureUrl = "hmhmhm",
        ),
        onReloadClick = {},
        onPopStackBack = {},
    )
}