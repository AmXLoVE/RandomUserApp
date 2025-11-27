package ru.myapplication.randomuserapp.presentation.userdetail.model

import kotlinx.serialization.Serializable

@Serializable
internal data class UserDetailArgs(
    val id: Long,
)