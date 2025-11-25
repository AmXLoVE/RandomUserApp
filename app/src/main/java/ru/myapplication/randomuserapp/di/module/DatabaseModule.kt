package ru.myapplication.randomuserapp.di.module

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import ru.myapplication.randomuserapp.data.datasource.local.AppDatabase
import ru.myapplication.randomuserapp.data.datasource.local.UserListDao
import javax.inject.Singleton

@Module
internal class DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        application: Application,
    ): AppDatabase = Room.databaseBuilder(
        context = application.applicationContext,
        klass = AppDatabase::class.java,
        name = DATABASE_NAME,
    ).build()

    @Singleton
    @Provides
    fun provideUserListDao(database: AppDatabase): UserListDao = database.userListDao()

    private companion object {
        const val DATABASE_NAME = "database_name"
    }
}