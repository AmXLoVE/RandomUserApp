package ru.myapplication.randomuserapp.di.module.vm

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import ru.myapplication.randomuserapp.presentation.LocalViewModelFactory

@Composable
inline fun <reified VM : ViewModel> daggerViewModel(
    factory: ViewModelProvider.Factory = LocalViewModelFactory.current,
    viewModelStoreOwner: ViewModelStoreOwner,
): VM {
    return ViewModelProvider(viewModelStoreOwner, factory)[VM::class.java]
}