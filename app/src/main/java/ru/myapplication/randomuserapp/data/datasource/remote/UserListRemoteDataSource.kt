package ru.myapplication.randomuserapp.data.datasource.remote

import ru.myapplication.randomuserapp.data.datasource.remote.model.UserListDto
import ru.myapplication.randomuserapp.data.repository.model.UpdateUserListParams
import javax.inject.Inject

internal class UserListRemoteDataSource @Inject constructor(
    private val api: RandomUserApi,
) {

    suspend fun requestUserList(params: UpdateUserListParams): UserListDto = api.getUserList(
        gender = params.gender,
        name = params.name,
        location = params.location,
        email = params.email,
        login = params.login,
        registered = params.registered,
        dob = params.dob,
        phone = params.phone,
        cell = params.cell,
        id = params.id,
        picture = params.picture,
        nat = params.nat,
    )
}