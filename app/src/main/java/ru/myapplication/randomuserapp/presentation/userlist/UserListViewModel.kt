package ru.myapplication.randomuserapp.presentation.userlist

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.myapplication.randomuserapp.domain.userlist.UserListRepository
import ru.myapplication.randomuserapp.presentation.userlist.model.UserListState
import javax.inject.Inject

internal class UserListViewModel @Inject constructor(
    private val userListRepository: UserListRepository,
) : ViewModel() {

    private val _state: MutableStateFlow<UserListState> = MutableStateFlow(UserListState.Loading)
    val state: StateFlow<UserListState> = _state.asStateFlow()

    init {
        Log.i("asdfasdf", "$userListRepository")
    }
}