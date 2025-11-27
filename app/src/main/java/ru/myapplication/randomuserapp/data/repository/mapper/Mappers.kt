package ru.myapplication.randomuserapp.data.repository.mapper

import ru.myapplication.randomuserapp.data.datasource.local.model.UserBirthdayInfoEntity
import ru.myapplication.randomuserapp.data.datasource.local.model.UserEntity
import ru.myapplication.randomuserapp.data.datasource.local.model.UserLocationInfoEntity
import ru.myapplication.randomuserapp.data.datasource.local.model.UserLoginInfoEntity
import ru.myapplication.randomuserapp.data.datasource.local.model.UserNameInfoEntity
import ru.myapplication.randomuserapp.data.datasource.local.model.UserPictureInfoEntity
import ru.myapplication.randomuserapp.data.datasource.remote.model.UserDto
import ru.myapplication.randomuserapp.data.datasource.remote.model.UserListDto
import ru.myapplication.randomuserapp.domain.usercreate.GenderDomain
import ru.myapplication.randomuserapp.domain.userlist.model.UserBirthdayInfoDomain
import ru.myapplication.randomuserapp.domain.userlist.model.UserDomain
import ru.myapplication.randomuserapp.domain.userlist.model.UserLocationInfoDomain
import ru.myapplication.randomuserapp.domain.userlist.model.UserLoginInfoDomain
import ru.myapplication.randomuserapp.domain.userlist.model.UserNameInfoDomain
import ru.myapplication.randomuserapp.domain.userlist.model.UserPictureInfoDomain
import java.sql.Date

internal fun UserDto.toEntity() = UserEntity(
    uuid = login.uuid,
    phone = phone,
    cellNumber = cell,
    gender = gender,
    email = email,
    nat = nat,
    name = UserNameInfoEntity(
        title = name.title,
        firstName = name.first,
        lastName = name.last,
    ),
    birthday = UserBirthdayInfoEntity(
        age = dob.age,
        date = Date(1),
    ),
    location = UserLocationInfoEntity(
        street = location.street.name,
        city = location.city,
        state = location.state,
        country = location.country,
        postcode = location.postcode,
        coordinates = "${location.coordinates.latitude} ${location.coordinates.longitude}",
    ),
    login = UserLoginInfoEntity(
        username = login.username,
        password = login.password,
        salt = login.salt,
    ),
    picture = UserPictureInfoEntity(
        large = picture.large,
        medium = picture.medium,
        thumbnail = picture.thumbnail,
    ),
)

internal fun UserListDto?.toEntity() = this?.results?.map { it.toEntity() } ?: emptyList()

internal fun UserEntity.toDomain() = UserDomain(
    id = id,
    phone = phone,
    cellNumber = cellNumber,
    gender = when (gender) {
        "male" -> GenderDomain.MALE
        "female" -> GenderDomain.FEMALE
        else -> error("Бывает только 2 пола :-)")
    },
    email = email,
    name = UserNameInfoDomain(
        title = name.title,
        firstName = name.firstName,
        lastName = name.lastName,
    ),
    nat = nat,
    birthday = UserBirthdayInfoDomain(
        age = birthday.age,
        date = birthday.date,
    ),
    location = UserLocationInfoDomain(
        street = location.street,
        city = location.city,
        state = location.state,
        country = location.country,
        postcode = location.postcode,
        coordinates = location.coordinates,
    ),
    login = UserLoginInfoDomain(
        uuid = uuid,
        username = login.username,
        password = login.password,
        salt = login.salt,
    ),
    picture = UserPictureInfoDomain(
        large = picture.large,
        medium = picture.medium,
        thumbnail = picture.thumbnail,
    ),
)
