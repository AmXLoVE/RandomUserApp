package ru.myapplication.randomuserapp.di.module.vm

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import ru.myapplication.randomuserapp.presentation.LocalViewModelFactory

@Composable
internal inline fun <reified VM : ViewModel> daggerViewModel(
    factory: ViewModelProvider.Factory = LocalViewModelFactory.current,
    viewModelStoreOwner: ViewModelStoreOwner,
    noinline initBlock: ((VM) -> Unit)? = null,
): VM {
    val needToInvokeInitBlock = !containViewModel(viewModelStoreOwner, VM::class.java.name)

    return ViewModelProvider(viewModelStoreOwner, factory)[VM::class.java].also { vm ->
        if (needToInvokeInitBlock) {
            initBlock?.invoke(vm)
        }
    }
}

private fun containViewModel(
    viewModelStoreOwner: ViewModelStoreOwner,
    klassName: String,
) = viewModelStoreOwner.viewModelStore.keys().any { it.contains(klassName) }
