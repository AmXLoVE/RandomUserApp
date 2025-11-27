package ru.myapplication.randomuserapp.presentation.userdetail.mapper

import ru.myapplication.randomuserapp.domain.userlist.model.UserDomain
import ru.myapplication.randomuserapp.presentation.userdetail.model.UserDetailEmailInfo
import ru.myapplication.randomuserapp.presentation.userdetail.model.UserDetailLocationInfo
import ru.myapplication.randomuserapp.presentation.userdetail.model.UserDetailPersonalInfo
import ru.myapplication.randomuserapp.presentation.userdetail.model.UserDetailPhoneInfo
import ru.myapplication.randomuserapp.presentation.userdetail.model.UserDetailState
import javax.inject.Inject

internal class UserDetailUiStateMapper @Inject constructor() {

    fun map(userDomain: UserDomain): UserDetailState.Content = UserDetailState.Content(
        personalInfo = UserDetailPersonalInfo(
            firstName = userDomain.name.firstName,
            lastName = userDomain.name.lastName,
            gender = userDomain.gender.value,
            age = userDomain.birthday.age.toString(),
            birthdate = userDomain.birthday.date.toString(), // todo
        ),
        phoneInfo = UserDetailPhoneInfo(
            phoneNumber = userDomain.phone,
            cellNumber = userDomain.cellNumber,
        ),
        emailInfo = UserDetailEmailInfo(
            email = userDomain.email,
            username = userDomain.login.username,
        ),
        locationInfo = UserDetailLocationInfo(
            city = userDomain.location.city,
            state = userDomain.location.state,
            street = userDomain.location.street,
            postcode = userDomain.location.postcode,
            coordinates = userDomain.location.coordinates,
        ),
        pictureUrl = userDomain.picture.large,
    )
}