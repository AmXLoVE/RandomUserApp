package ru.myapplication.randomuserapp.presentation.userlist.model

internal data class UserDetails(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val gender: String,
    val age: Int,
    val email: String,
    val phone: String,
    val picture: String,
    val country: String,
    val photoUrl: String,
)