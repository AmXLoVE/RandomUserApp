package ru.myapplication.randomuserapp.presentation.usercreate

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.myapplication.randomuserapp.domain.usercreate.GetGendersUseCase
import ru.myapplication.randomuserapp.domain.usercreate.GetNationalityUseCase
import ru.myapplication.randomuserapp.domain.userlist.UserListRepository
import ru.myapplication.randomuserapp.presentation.usercreate.model.UserCreateState
import ru.myapplication.randomuserapp.presentation.userlist.model.UserListArgs
import javax.inject.Inject

internal class UserCreateViewModel @Inject constructor(
    private val getGendersUseCase: GetGendersUseCase,
    private val getNationalityUseCase: GetNationalityUseCase,
    private val repository: UserListRepository,
) : ViewModel() {

    private val _state: MutableStateFlow<UserCreateState> =
        MutableStateFlow(UserCreateState.Loading)

    val state: StateFlow<UserCreateState> = _state.asStateFlow()

    fun init() {
        viewModelScope.launch {
            val genders = getGendersUseCase()
            val nationality = getNationalityUseCase()

            _state.update {
                UserCreateState.Content(
                    selectedGender = repository.getSavedGender() ?: genders.first().value,
                    selectedNationality = repository.getSavedNationality() ?: nationality.first().value,
                    genders = genders.map { it.value },
                    nationality = nationality.map { it.value },
                )
            }
        }
    }

    fun onGenderSelected(item: String) {
        val currentState = (_state.value as? UserCreateState.Content) ?: return

        repository.saveGender(item)

        _state.update { currentState.copy(selectedGender = item) }
    }

    fun onNationalitySelected(item: String) {
        val currentState = (_state.value as? UserCreateState.Content) ?: return

        repository.saveNationality(item)

        _state.update { currentState.copy(selectedNationality = item) }
    }

    fun onGenerateClick(navController: NavController) {
        val currentState = (_state.value as? UserCreateState.Content) ?: return

        navController.navigate(
            UserListArgs(
                gender = currentState.selectedGender,
                nationality = currentState.selectedNationality,
            )
        )
    }
}
