package ru.myapplication.randomuserapp.presentation.userdetail.model

internal sealed interface UserDetailState {

    data object Error : UserDetailState

    data object Loading : UserDetailState

    data class Content(
        val personalInfo: UserDetailPersonalInfo,
        val phoneInfo: UserDetailPhoneInfo,
        val emailInfo: UserDetailEmailInfo,
        val locationInfo: UserDetailLocationInfo,
        val pictureUrl: String,
    ) : UserDetailState
}