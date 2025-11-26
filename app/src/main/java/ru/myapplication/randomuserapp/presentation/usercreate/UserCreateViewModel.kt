package ru.myapplication.randomuserapp.presentation.usercreate

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.myapplication.randomuserapp.presentation.usercreate.model.UserCreateData
import ru.myapplication.randomuserapp.presentation.usercreate.model.UserCreateState
import javax.inject.Inject

internal class UserCreateViewModel @Inject constructor() : ViewModel() {

    private val _state: MutableStateFlow<UserCreateState> =
        MutableStateFlow(UserCreateState.Loading)

    val state: StateFlow<UserCreateState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            delay(3000)
            _state.update {
                UserCreateState.Content(
                    userCreateData = UserCreateData(
                        genderList = listOf(
                            "Male",
                            "Female",
                        ),
                        countryList = listOf(
                            "Unites States",
                            "Russian Federation",
                            "Australia",
                        )
                    )
                )
            }
        }
    }

    fun generateUser() {
        viewModelScope.launch {
            try {

            } catch (e: Exception) {
                _state.update {
                    UserCreateState.Error
                }
            }
        }
    }
}
