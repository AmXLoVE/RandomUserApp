package ru.myapplication.randomuserapp.domain.userlist

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.myapplication.randomuserapp.data.repository.model.UpdateUserListParams
import ru.myapplication.randomuserapp.domain.userlist.model.UserDomain

internal interface UserListRepository {

    suspend fun getUserById(id: Long): UserDomain

    fun loadWithPagination(params: UpdateUserListParams): Flow<PagingData<UserDomain>>
}