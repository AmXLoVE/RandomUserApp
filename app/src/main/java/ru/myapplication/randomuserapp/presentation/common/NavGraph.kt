package ru.myapplication.randomuserapp.presentation.common

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import ru.myapplication.randomuserapp.di.module.vm.daggerViewModel
import ru.myapplication.randomuserapp.presentation.LocalNavController
import ru.myapplication.randomuserapp.presentation.usercreate.UserCreateScreen
import ru.myapplication.randomuserapp.presentation.usercreate.UserCreateViewModel
import ru.myapplication.randomuserapp.presentation.userdetail.UserDetailScreen
import ru.myapplication.randomuserapp.presentation.userdetail.UserDetailViewModel
import ru.myapplication.randomuserapp.presentation.userlist.UserListScreen
import ru.myapplication.randomuserapp.presentation.userlist.UserListViewModel

const val USER_LIST_DEST = "user_list_dest"
const val USER_DETAIL_DEST = "user_detail_dest"
const val USER_CREATE_DEST = "user_create_dest"

@Composable
internal fun NavGraph() {
    NavHost(
        navController = LocalNavController.current,
        startDestination = USER_CREATE_DEST,
    ) {
        composable(route = USER_LIST_DEST) {
            val userListViewModel = daggerViewModel<UserListViewModel>(
                viewModelStoreOwner = it,
            )

            UserListScreen(
                vm = userListViewModel,
            )
        }

        composable(
            route = "$USER_DETAIL_DEST/{id}",
            arguments = listOf(
                navArgument(
                    name = "id",
                ) {
                    type = NavType.IntType
                }
            )
        ) {entry ->
            val id = entry.arguments?.getInt("id") ?: 0
            val userDetailViewModel = daggerViewModel<UserDetailViewModel>(
                viewModelStoreOwner = entry,
            )

            UserDetailScreen(
                id = id,
                vm = userDetailViewModel,
            )
        }

        composable(route = USER_CREATE_DEST) {
            val userCreateViewModel = daggerViewModel<UserCreateViewModel>(
                viewModelStoreOwner = it,
            )

            UserCreateScreen(
                vm = userCreateViewModel,
            )
        }
    }
}