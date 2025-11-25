package ru.myapplication.randomuserapp.di.module

import dagger.Binds
import dagger.Module
import ru.myapplication.randomuserapp.data.repository.UserListRepositoryImpl
import ru.myapplication.randomuserapp.domain.userlist.UserListRepository
import javax.inject.Singleton

@Module
internal abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindUserListRepository(impl: UserListRepositoryImpl): UserListRepository
}