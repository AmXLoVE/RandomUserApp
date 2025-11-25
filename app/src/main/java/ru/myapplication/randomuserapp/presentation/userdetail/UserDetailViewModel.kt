package ru.myapplication.randomuserapp.presentation.userdetail

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.myapplication.randomuserapp.presentation.userdetail.model.UserDetailState
import javax.inject.Inject

internal class UserDetailViewModel @Inject constructor(): ViewModel() {

    private val _state: MutableStateFlow<UserDetailState> = MutableStateFlow(UserDetailState.Loading)
    val state: StateFlow<UserDetailState> = _state.asStateFlow()
}