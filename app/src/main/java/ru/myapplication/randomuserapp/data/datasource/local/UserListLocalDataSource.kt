package ru.myapplication.randomuserapp.data.datasource.local

import kotlinx.coroutines.flow.Flow
import ru.myapplication.randomuserapp.data.datasource.local.model.UserEntity
import javax.inject.Inject

internal class UserListLocalDataSource @Inject constructor(
    private val userListDao: UserListDao,
) {

    fun observe(): Flow<List<UserEntity>> = userListDao.getAll()

    fun update(userList: List<UserEntity>) {
        userListDao.insertAll(
            users = userList,
        )
    }
}