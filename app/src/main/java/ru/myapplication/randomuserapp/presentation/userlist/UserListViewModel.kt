package ru.myapplication.randomuserapp.presentation.userlist

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.myapplication.randomuserapp.domain.userlist.UserListRepository
import ru.myapplication.randomuserapp.presentation.userlist.model.UserListState
import ru.myapplication.randomuserapp.presentation.userlist.model.UserListUserDetail
import javax.inject.Inject

internal class UserListViewModel @Inject constructor(
    private val userListRepository: UserListRepository,
) : ViewModel() {

    private val _state: MutableStateFlow<UserListState> = MutableStateFlow(UserListState.Loading)
    val state: StateFlow<UserListState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            try {
                _state.update {
                    UserListState.Content(
                        userList = listOf(
                            UserListUserDetail(
                                id = 1,
                                firstName = "Alex",
                                lastName = "Sun",
                                gender = "Male",
                                age = 33,
                                email = "asd@asd",
                                phone = "434342",
                                picture = "123",
                                country = "USA",
                                photoUrl = "123"
                            ),
                            UserListUserDetail(
                                id = 2,
                                firstName = "Good",
                                lastName = "Boy",
                                gender = "Female",
                                age = 11,
                                email = "asd@asd",
                                phone = "+6384728",
                                picture = "123",
                                country = "CANADA",
                                photoUrl = "123"
                            ),
                            UserListUserDetail(
                                id = 3,
                                firstName = "Opopopo",
                                lastName = "Gooooo",
                                gender = "Male",
                                age = 22,
                                email = "cvbc@vbcvb",
                                phone = "+738383838",
                                picture = "123",
                                country = "RUSSIA",
                                photoUrl = "123"
                            ),
                        )
                    )
                }
            }
            catch (e: Exception) {
                _state.update {
                    UserListState.Error
                }
            }
        }
    }

    fun update() {

    }
}