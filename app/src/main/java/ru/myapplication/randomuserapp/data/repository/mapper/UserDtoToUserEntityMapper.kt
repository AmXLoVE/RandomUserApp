package ru.myapplication.randomuserapp.data.repository.mapper

import ru.myapplication.randomuserapp.data.datasource.local.model.UserBirthdayInfoEntity
import ru.myapplication.randomuserapp.data.datasource.local.model.UserEntity
import ru.myapplication.randomuserapp.data.datasource.local.model.UserLocationInfoEntity
import ru.myapplication.randomuserapp.data.datasource.local.model.UserLoginInfoEntity
import ru.myapplication.randomuserapp.data.datasource.local.model.UserNameInfoEntity
import ru.myapplication.randomuserapp.data.datasource.local.model.UserPictureInfoEntity
import ru.myapplication.randomuserapp.data.datasource.remote.model.UserDto
import javax.inject.Inject

internal class UserDtoToUserEntityMapper @Inject constructor() {

    fun map(userDto: UserDto): UserEntity = with(userDto) {
        UserEntity(
            uuid = login.uuid,
            phone = phone,
            gender = gender,
            email = email,
            name = UserNameInfoEntity(
                title = name.title,
                firstName = name.first,
                lastName = name.last,
            ),
            birthday = UserBirthdayInfoEntity(
                age = dob.age,
                date = dob.date,
            ),
            location = UserLocationInfoEntity(
                street = location.street.name,
                city = location.city,
                state = location.state,
                country = location.country,
                postcode = location.postcode,
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
    }
}