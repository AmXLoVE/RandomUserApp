package ru.myapplication.randomuserapp.presentation.common

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.myapplication.randomuserapp.di.module.vm.daggerViewModel
import ru.myapplication.randomuserapp.presentation.LocalNavController
import ru.myapplication.randomuserapp.presentation.userlist.UserListScreen
import ru.myapplication.randomuserapp.presentation.userlist.UserListViewModel

const val USER_LIST_DEST = "user_list_dest"
const val USER_DETAIL_DEST = "user_detail_dest"
const val USER_CREATE_DEST = "user_create_dest"

@Composable
internal fun NavGraph() {
    NavHost(
        navController = LocalNavController.current,
        startDestination = USER_LIST_DEST,
    ) {
        composable(route = USER_LIST_DEST) {
            val userListViewModel = daggerViewModel<UserListViewModel>(
                viewModelStoreOwner = it,
            )

            UserListScreen(vm = userListViewModel)
        }

        composable(route = USER_DETAIL_DEST) {

        }

        composable(route = USER_CREATE_DEST) {

        }
    }
}
