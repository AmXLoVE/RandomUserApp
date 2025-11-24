package ru.myapplication.randomuserapp.presentation.usercreate

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class UserCreateViewModel @Inject constructor(): ViewModel() {

    private val _state = MutableStateFlow(State())
    val state = _state.asStateFlow()


}