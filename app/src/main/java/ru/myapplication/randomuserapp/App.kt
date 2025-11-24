package ru.myapplication.randomuserapp

import android.app.Application
import ru.myapplication.randomuserapp.di.ApplicationComponent
import ru.myapplication.randomuserapp.di.DaggerApplicationComponent

class App : Application() {

    lateinit var appComponent: ApplicationComponent
        private set



    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerApplicationComponent.factory().create(this)
    }
}