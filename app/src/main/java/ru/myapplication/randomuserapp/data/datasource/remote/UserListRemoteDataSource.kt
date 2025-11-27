package ru.myapplication.randomuserapp.data.datasource.remote

import ru.myapplication.randomuserapp.data.datasource.remote.model.UserListDto
import ru.myapplication.randomuserapp.data.repository.model.UpdateUserListParams
import javax.inject.Inject

internal class UserListRemoteDataSource @Inject constructor(
    private val api: RandomUserApi,
) {

    suspend fun requestUserList(
        params: UpdateUserListParams,
        page: Int? = null,
        results: Int? = null,
    ): UserListDto = api.getUserList(
        page = page,
        results = results,
        gender = params.gender,
        nat = params.nat,
    )
}