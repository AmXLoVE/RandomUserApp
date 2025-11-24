package ru.myapplication.randomuserapp.presentation.userlist

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.myapplication.randomuserapp.presentation.userlist.model.UserListState
import javax.inject.Inject

internal class UserListViewModel @Inject constructor() : ViewModel() {

    private val _state: MutableStateFlow<UserListState> = MutableStateFlow(UserListState.Loading)
    val state: StateFlow<UserListState> = _state.asStateFlow()
}