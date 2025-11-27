package ru.myapplication.randomuserapp.data.datasource.local.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
internal data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val uuid: String,
    val phone: String,
    val gender: String,
    val email: String,
    val nat: String,
    @Embedded val name: UserNameInfoEntity,
    @Embedded val birthday: UserBirthdayInfoEntity,
    @Embedded val location: UserLocationInfoEntity,
    @Embedded val login: UserLoginInfoEntity,
    @Embedded val picture: UserPictureInfoEntity,
)


data class UserPictureInfoEntity(
    val large: String,
    val medium: String,
    val thumbnail: String,
)

data class UserNameInfoEntity(
    val title: String,
    val firstName: String,
    val lastName: String,
)

data class UserLocationInfoEntity(
    val street: String,
    val city: String,
    val state: String,
    val country: String,
    val postcode: String,
)

data class UserBirthdayInfoEntity(
    val age: Int,
    val date: Date,
)

data class UserLoginInfoEntity(
    val username: String,
    val password: String,
    val salt: String,
)
