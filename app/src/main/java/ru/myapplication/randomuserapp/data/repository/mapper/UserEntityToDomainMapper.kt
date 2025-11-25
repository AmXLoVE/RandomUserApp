package ru.myapplication.randomuserapp.data.repository.mapper

import ru.myapplication.randomuserapp.data.datasource.local.model.UserEntity
import ru.myapplication.randomuserapp.domain.userlist.model.UserBirthdayInfoDomain
import ru.myapplication.randomuserapp.domain.userlist.model.UserDomain
import ru.myapplication.randomuserapp.domain.userlist.model.UserGenderDomain
import ru.myapplication.randomuserapp.domain.userlist.model.UserLocationInfoDomain
import ru.myapplication.randomuserapp.domain.userlist.model.UserLoginInfoDomain
import ru.myapplication.randomuserapp.domain.userlist.model.UserNameInfoDomain
import ru.myapplication.randomuserapp.domain.userlist.model.UserPictureInfoDomain
import javax.inject.Inject

internal class UserEntityToDomainMapper @Inject constructor() {

    fun map(userEntity: UserEntity): UserDomain = with(userEntity) {
        UserDomain(
            phone = phone,
            gender = defineGender(gender),
            email = email,
            name = UserNameInfoDomain(
                title = name.title,
                firstName = name.firstName,
                lastName = name.lastName,
            ),
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
    }

    private fun defineGender(gender: String): UserGenderDomain = when (gender) {
        MALE -> UserGenderDomain.MALE
        FEMALE -> UserGenderDomain.FEMALE
        else -> error("Бывает только 2 пола :-)")
    }

    private companion object {
        const val MALE = "male"
        const val FEMALE = "female"
    }
}