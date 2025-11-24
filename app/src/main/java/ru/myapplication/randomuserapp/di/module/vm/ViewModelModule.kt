package ru.myapplication.randomuserapp.di.module.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.myapplication.randomuserapp.presentation.userdetail.UserDetailViewModel
import ru.myapplication.randomuserapp.presentation.userlist.UserListViewModel

@Module
internal abstract class ViewModelModule {


    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory


    @Binds
    @IntoMap
    @ViewModelKey(UserListViewModel::class)
    abstract fun bindMainViewModel(vm: UserListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(UserDetailViewModel::class)
    abstract fun bindDetailsViewModel(vm: UserDetailViewModel): ViewModel
}