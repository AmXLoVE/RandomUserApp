package ru.myapplication.randomuserapp.domain.userlist.model

import ru.myapplication.randomuserapp.domain.usercreate.GenderDomain
import java.util.Date

internal data class UserDomain(
    val id: Long,
    val phone: String,
    val cellNumber: String,
    val gender: GenderDomain,
    val email: String,
    val nat: String,
    val name: UserNameInfoDomain,
    val birthday: UserBirthdayInfoDomain,
    val location: UserLocationInfoDomain,
    val login: UserLoginInfoDomain,
    val picture: UserPictureInfoDomain,
)

internal data class UserPictureInfoDomain(
    val large: String,
    val medium: String,
    val thumbnail: String,
)

internal data class UserNameInfoDomain(
    val title: String,
    val firstName: String,
    val lastName: String,
)

internal data class UserLocationInfoDomain(
    val street: String,
    val city: String,
    val state: String,
    val country: String,
    val postcode: String,
    val coordinates: String,
)

internal data class UserBirthdayInfoDomain(
    val age: Int,
    val date: Date,
)

internal data class UserLoginInfoDomain(
    val uuid: String,
    val username: String,
    val password: String,
    val salt: String,
)
