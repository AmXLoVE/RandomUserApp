package ru.myapplication.randomuserapp.data.repository.model

internal data class UpdateUserListParams(
    val gender: String? = null,
    val name: String? = null,
    val location: String? = null,
    val email: String? = null,
    val login: String? = null,
    val registered: String? = null,
    val dob: String? = null,
    val phone: String? = null,
    val cell: String? = null,
    val id: String? = null,
    val picture: String? = null,
    val nat: String? = null,
)