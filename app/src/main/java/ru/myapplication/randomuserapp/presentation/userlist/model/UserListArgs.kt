package ru.myapplication.randomuserapp.presentation.userlist.model

import kotlinx.serialization.Serializable

@Serializable
internal data class UserListArgs(
    val gender: String,
    val nationality: String,
)