package ru.myapplication.randomuserapp.data.mediator

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import ru.myapplication.randomuserapp.data.datasource.local.UserListLocalDataSource
import ru.myapplication.randomuserapp.data.datasource.local.model.UserEntity
import ru.myapplication.randomuserapp.data.datasource.remote.UserListRemoteDataSource
import ru.myapplication.randomuserapp.data.repository.mapper.toEntity
import ru.myapplication.randomuserapp.data.repository.model.UpdateUserListParams
import kotlin.concurrent.atomics.AtomicInt
import kotlin.concurrent.atomics.ExperimentalAtomicApi
import kotlin.concurrent.atomics.incrementAndFetch

@OptIn(ExperimentalPagingApi::class)
internal class UserListRemoteMediator(
    private val userListRemoteDataSource: UserListRemoteDataSource,
    private val userListLocalDataSource: UserListLocalDataSource,
    private val params: UpdateUserListParams,
) : RemoteMediator<Int, UserEntity>() {

    @OptIn(ExperimentalAtomicApi::class)
    private val pageNumber = AtomicInt(1)

    @OptIn(ExperimentalAtomicApi::class)
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, UserEntity>
    ): MediatorResult {
        val page = when (loadType) {
            LoadType.REFRESH -> pageNumber.load()
            LoadType.PREPEND -> return MediatorResult.Success(endOfPaginationReached = true)
            LoadType.APPEND -> pageNumber.incrementAndFetch()
        }

        try {
            val response = userListRemoteDataSource.requestUserList(
                params = params,
                page = page,
                results = state.config.pageSize
            )

            val endReached = response.results.isEmpty()

            userListLocalDataSource.updateUserList(userList = response.toEntity())

            return MediatorResult.Success(endOfPaginationReached = endReached)
        } catch (e: Exception) {
            return MediatorResult.Error(e)
        }
    }
}