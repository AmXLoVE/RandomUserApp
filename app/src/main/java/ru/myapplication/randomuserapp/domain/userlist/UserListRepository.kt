package ru.myapplication.randomuserapp.domain.userlist

import kotlinx.coroutines.flow.Flow
import ru.myapplication.randomuserapp.data.repository.model.UpdateUserListParams
import ru.myapplication.randomuserapp.domain.userlist.model.UserDomain

internal interface UserListRepository {

    fun observeUsers(params: UpdateUserListParams): Flow<List<UserDomain>>

    suspend fun update(params: UpdateUserListParams)
}