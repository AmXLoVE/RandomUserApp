package ru.myapplication.randomuserapp.presentation.usercreate.model

internal sealed interface UserCreateState {
    data object Loading : UserCreateState

    data object Error : UserCreateState

    data class Content(
        val selectedGender: String,
        val selectedNationality: String,
        val genders: List<String>,
        val nationality: List<String>,
    ) : UserCreateState
}