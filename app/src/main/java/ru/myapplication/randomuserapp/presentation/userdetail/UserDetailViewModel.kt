package ru.myapplication.randomuserapp.presentation.userdetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.myapplication.randomuserapp.presentation.userdetail.model.UserDetailEmailInfo
import ru.myapplication.randomuserapp.presentation.userdetail.model.UserDetailLocationInfo
import ru.myapplication.randomuserapp.presentation.userdetail.model.UserDetailModel
import ru.myapplication.randomuserapp.presentation.userdetail.model.UserDetailPersonalInfo
import ru.myapplication.randomuserapp.presentation.userdetail.model.UserDetailPhoneInfo
import ru.myapplication.randomuserapp.presentation.userdetail.model.UserDetailState
import javax.inject.Inject
import kotlin.toString

internal class UserDetailViewModel @Inject constructor(
): ViewModel() {

    private val _state: MutableStateFlow<UserDetailState> = MutableStateFlow(UserDetailState.Loading)
    val state: StateFlow<UserDetailState> = _state.asStateFlow()

    fun getUserDetail(userId: Int) {
        try{

            viewModelScope.launch {
                _state.update {
                    UserDetailState.Content(
                        UserDetailModel(
                            personalInfo = UserDetailPersonalInfo(
                                firstName = userId.toString(),
                                lastName = userId.toString(),
                                gender = userId.toString(),
                                age = userId.toString(),
                                birthdate = userId.toString(),
                            ),
                            UserDetailPhoneInfo(
                                phoneNumber = userId.toString(),
                                cellNumber = userId.toString(),
                            ),
                            UserDetailEmailInfo(
                                email = userId.toString(),
                                username = userId.toString(),
                            ),
                            UserDetailLocationInfo(
                                city = userId.toString(),
                                state = userId.toString(),
                                street = userId.toString(),
                                postcode = userId.toString(),
                                coordinates = userId.toString(),
                            ),
                            pictureUrl = "",
                        ),
                    )
                }
            }
        }
        catch (e: Exception) {
            UserDetailState.Error
        }
    }
}