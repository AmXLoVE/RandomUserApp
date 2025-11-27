package ru.myapplication.randomuserapp.presentation.userdetail.model

internal data class UserDetailPersonalInfo(
    val firstName: String,
    val lastName: String,
    val gender: String,
    val age: String,
    val birthdate: String,
)

internal data class UserDetailPhoneInfo(
    val phoneNumber: String,
    val cellNumber: String,
)

internal data class UserDetailEmailInfo(
    val email: String,
    val username: String,
)

internal data class UserDetailLocationInfo(
    val city: String,
    val state: String,
    val street: String,
    val postcode: String,
    val coordinates: String,
)