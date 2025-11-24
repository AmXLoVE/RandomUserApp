package ru.myapplication.randomuserapp.presentation.usercreate.model

internal sealed interface UserCreateState {
    data object Loading : UserCreateState

    data object Error : UserCreateState

    data class Content(
        val genderList: List<Gender>,
        val countryList: List<Country>,
    ) : UserCreateState
}