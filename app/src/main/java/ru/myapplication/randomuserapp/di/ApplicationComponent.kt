package ru.myapplication.randomuserapp.di

import android.app.Application
import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.myapplication.randomuserapp.di.module.DatabaseModule
import ru.myapplication.randomuserapp.di.module.LocalStoreModule
import ru.myapplication.randomuserapp.di.module.NetworkModule
import ru.myapplication.randomuserapp.di.module.RepositoryModule
import ru.myapplication.randomuserapp.di.module.vm.ViewModelModule
import ru.myapplication.randomuserapp.presentation.MainActivity
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ViewModelModule::class,
    NetworkModule::class,
    DatabaseModule::class,
    LocalStoreModule::class,
    RepositoryModule::class,
])
interface ApplicationComponent {

    fun inject(activity: MainActivity)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}