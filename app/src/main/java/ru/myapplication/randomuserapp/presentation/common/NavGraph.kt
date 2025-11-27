package ru.myapplication.randomuserapp.presentation.common

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import ru.myapplication.randomuserapp.di.module.vm.daggerViewModel
import ru.myapplication.randomuserapp.presentation.LocalNavController
import ru.myapplication.randomuserapp.presentation.usercreate.UserCreateScreen
import ru.myapplication.randomuserapp.presentation.usercreate.UserCreateViewModel
import ru.myapplication.randomuserapp.presentation.usercreate.model.UserCreateArgs
import ru.myapplication.randomuserapp.presentation.userdetail.UserDetailScreen
import ru.myapplication.randomuserapp.presentation.userdetail.UserDetailViewModel
import ru.myapplication.randomuserapp.presentation.userdetail.model.UserDetailArgs
import ru.myapplication.randomuserapp.presentation.userlist.UserListScreen
import ru.myapplication.randomuserapp.presentation.userlist.UserListViewModel
import ru.myapplication.randomuserapp.presentation.userlist.model.UserListArgs

const val USER_LIST_DEST = "user_list_dest"

@Composable
internal fun NavGraph() {
    NavHost(
        navController = LocalNavController.current,
        startDestination = UserCreateArgs,
    ) {
        composable<UserListArgs> { entry ->
            val userListViewModel = daggerViewModel<UserListViewModel>(viewModelStoreOwner = entry) {
                it.init(entry.toRoute())
            }

            UserListScreen(vm = userListViewModel)
        }

        composable<UserDetailArgs> { entry ->
            val userDetailViewModel = daggerViewModel<UserDetailViewModel>(viewModelStoreOwner = entry) {
                it.init(entry.toRoute())
            }

            UserDetailScreen(vm = userDetailViewModel)
        }

        composable<UserCreateArgs> { entry ->
            val userCreateViewModel = daggerViewModel<UserCreateViewModel>(viewModelStoreOwner = entry) {
                it.init()
            }

            UserCreateScreen(vm = userCreateViewModel)
        }
    }
}