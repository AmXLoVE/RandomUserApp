package ru.myapplication.randomuserapp.data.repository

import kotlinx.coroutines.flow.Flow
import ru.myapplication.randomuserapp.data.datasource.local.UserListLocalDataSource
import ru.myapplication.randomuserapp.data.datasource.local.model.UserEntity
import ru.myapplication.randomuserapp.data.datasource.remote.UserListRemoteDataSource
import ru.myapplication.randomuserapp.data.datasource.remote.model.UserListDto
import ru.myapplication.randomuserapp.data.repository.mapper.UserDtoToUserEntityMapper
import ru.myapplication.randomuserapp.data.repository.model.UpdateUserListParams
import ru.myapplication.randomuserapp.domain.userlist.UserListRepository
import ru.myapplication.randomuserapp.domain.userlist.model.UserDomain
import javax.inject.Inject

internal class UserListRepositoryImpl @Inject constructor(
    private val userListRemoteDataSource: UserListRemoteDataSource,
    private val userListLocalDataSource: UserListLocalDataSource,
    private val userDtoToEntityMapper: UserDtoToUserEntityMapper,
) : UserListRepository {

    override fun observeUsers(params: UpdateUserListParams): Flow<List<UserDomain>> {
        TODO("Not yet implemented")
    }

    override suspend fun update(params: UpdateUserListParams) {
        val response: UserListDto = userListRemoteDataSource.requestUserList(params = params)

        val entity: List<UserEntity> = response.userDtos.map { userDtoToEntityMapper.map(it) }


    }
}