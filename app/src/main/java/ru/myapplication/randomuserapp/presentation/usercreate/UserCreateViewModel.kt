package ru.myapplication.randomuserapp.presentation.usercreate

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.myapplication.randomuserapp.presentation.usercreate.model.UserCreateState
import javax.inject.Inject

internal class UserCreateViewModel @Inject constructor(): ViewModel() {

    private val _state: MutableStateFlow<UserCreateState> = MutableStateFlow(UserCreateState.Loading)
    val state: StateFlow<UserCreateState> = _state.asStateFlow()


}