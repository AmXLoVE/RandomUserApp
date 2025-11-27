package ru.myapplication.randomuserapp.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.myapplication.randomuserapp.data.datasource.local.UserListLocalDataSource
import ru.myapplication.randomuserapp.data.datasource.remote.UserListRemoteDataSource
import ru.myapplication.randomuserapp.data.mediator.UserListRemoteMediator
import ru.myapplication.randomuserapp.data.repository.mapper.toDomain
import ru.myapplication.randomuserapp.data.repository.model.UpdateUserListParams
import ru.myapplication.randomuserapp.domain.userlist.UserListRepository
import ru.myapplication.randomuserapp.domain.userlist.model.UserDomain
import javax.inject.Inject

internal class UserListRepositoryImpl @Inject constructor(
    private val userListRemoteDataSource: UserListRemoteDataSource,
    private val userListLocalDataSource: UserListLocalDataSource,
) : UserListRepository {

    override suspend fun getUserById(id: Long): UserDomain {
        val userEntity = userListLocalDataSource.getUserById(id = id) ?: error("")

        return userEntity.toDomain()
    }

    @OptIn(ExperimentalPagingApi::class)
    override fun loadWithPagination(params: UpdateUserListParams): Flow<PagingData<UserDomain>> =
        Pager(
            config = PagingConfig(
                pageSize = 50,
                jumpThreshold = Int.MAX_VALUE,
            ),
            remoteMediator = UserListRemoteMediator(
                userListRemoteDataSource = userListRemoteDataSource,
                userListLocalDataSource = userListLocalDataSource,
                params = params,
            ),
            pagingSourceFactory = { userListLocalDataSource.getUserListWithPagination(params) }
        )
            .flow
            .map { pagingData ->
                pagingData.map { entity -> entity.toDomain() }
            }
}