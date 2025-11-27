package ru.myapplication.randomuserapp.presentation.userlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import androidx.paging.PagingData
import androidx.paging.cachedIn
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import ru.myapplication.randomuserapp.data.repository.model.UpdateUserListParams
import ru.myapplication.randomuserapp.domain.userlist.UserListRepository
import ru.myapplication.randomuserapp.domain.userlist.model.UserDomain
import ru.myapplication.randomuserapp.presentation.userdetail.model.UserDetailArgs
import ru.myapplication.randomuserapp.presentation.userlist.model.UserListArgs
import javax.inject.Inject

internal class UserListViewModel @Inject constructor(
    private val userListRepository: UserListRepository,
) : ViewModel() {

    private val _state: MutableStateFlow<PagingData<UserDomain>> = MutableStateFlow(PagingData.empty())
    val state: Flow<PagingData<UserDomain>> = _state.cachedIn(viewModelScope)

    fun init(args: UserListArgs) {
        userListRepository
            .loadWithPagination(
                params = UpdateUserListParams(
                    gender = args.gender,
                    nat = args.nationality
                )
            )
            .onEach { newState -> _state.update { newState } }
            .flowOn(Dispatchers.IO)
            .launchIn(viewModelScope)
    }

    fun onUserClicked(navController: NavController, userId: Long) {
        navController.navigate(UserDetailArgs(id = userId))
    }
}