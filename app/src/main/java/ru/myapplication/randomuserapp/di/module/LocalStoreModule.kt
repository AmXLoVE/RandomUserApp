package ru.myapplication.randomuserapp.di.module

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalStoreModule {

    @Singleton
    @Provides
    fun provideSharedPreferences(app: Application): SharedPreferences =
        app.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)

    private companion object {
        const val SHARED_PREFERENCES_NAME = "sp_name"
    }
}