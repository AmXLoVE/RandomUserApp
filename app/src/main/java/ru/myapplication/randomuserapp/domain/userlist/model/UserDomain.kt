package ru.myapplication.randomuserapp.domain.userlist.model

import java.util.Date

data class UserDomain(
    val phone: String,
    val gender: UserGenderDomain,
    val email: String,
    val nat: String,
    val name: UserNameInfoDomain,
    val birthday: UserBirthdayInfoDomain,
    val location: UserLocationInfoDomain,
    val login: UserLoginInfoDomain,
    val picture: UserPictureInfoDomain,
)

data class UserPictureInfoDomain(
    val large: String,
    val medium: String,
    val thumbnail: String,
)

data class UserNameInfoDomain(
    val title: String,
    val firstName: String,
    val lastName: String,
)

data class UserLocationInfoDomain(
    val street: String,
    val city: String,
    val state: String,
    val country: String,
    val postcode: String,
)

data class UserBirthdayInfoDomain(
    val age: Int,
    val date: Date,
)

data class UserLoginInfoDomain(
    val uuid: String,
    val username: String,
    val password: String,
    val salt: String,
)

enum class UserGenderDomain {
    MALE, FEMALE
}
