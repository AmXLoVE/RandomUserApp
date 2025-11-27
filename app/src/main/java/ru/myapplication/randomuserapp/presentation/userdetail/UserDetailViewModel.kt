package ru.myapplication.randomuserapp.presentation.userdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.myapplication.randomuserapp.domain.userlist.UserListRepository
import ru.myapplication.randomuserapp.presentation.userdetail.mapper.UserDetailUiStateMapper
import ru.myapplication.randomuserapp.presentation.userdetail.model.UserDetailArgs
import ru.myapplication.randomuserapp.presentation.userdetail.model.UserDetailState
import javax.inject.Inject

internal class UserDetailViewModel @Inject constructor(
    private val userListRepository: UserListRepository,
    private val userDetailUiStateMapper: UserDetailUiStateMapper,
): ViewModel() {

    private val _state: MutableStateFlow<UserDetailState> = MutableStateFlow(UserDetailState.Loading)
    val state: StateFlow<UserDetailState> = _state.asStateFlow()

    private var args: UserDetailArgs? = null

    fun init(args: UserDetailArgs) {
        this.args = args

        update(id = args.id)
    }

    fun onReloadClick() {
        val id = args?.id ?: return

        update(id = id)
    }

    private fun update(id: Long) {
        _state.update { UserDetailState.Loading }

        viewModelScope.launch {
            try {
                val user = userDetailUiStateMapper.map(
                    userDomain = userListRepository.getUserById(id = id),
                )

                _state.update { user }
            } catch (e: Exception) {
                if (e is CancellationException) throw e

                _state.update { UserDetailState.Error }
            }
        }
    }
}