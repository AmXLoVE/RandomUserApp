package ru.myapplication.randomuserapp.data.datasource.local

import androidx.paging.PagingSource
import ru.myapplication.randomuserapp.data.datasource.local.model.UserEntity
import ru.myapplication.randomuserapp.data.repository.model.UpdateUserListParams
import javax.inject.Inject

internal class UserListLocalDataSource @Inject constructor(
    private val userListDao: UserListDao,
) {

    suspend fun updateUserList(userList: List<UserEntity>) = userListDao.insertAll(users = userList)

    fun getUserListWithPagination(
        params: UpdateUserListParams,
    ): PagingSource<Int, UserEntity> = userListDao.pagingSource(
        gender = params.gender,
        nat = params.nat,
    )

    suspend fun getUserById(id: Long) = userListDao.getUserById(id = id)
}