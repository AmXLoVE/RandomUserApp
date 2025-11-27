package ru.myapplication.randomuserapp.data.datasource.local

import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.paging.PagingSource
import ru.myapplication.randomuserapp.data.datasource.local.model.UserEntity
import ru.myapplication.randomuserapp.data.repository.model.UpdateUserListParams
import javax.inject.Inject

internal class UserListLocalDataSource @Inject constructor(
    private val userListDao: UserListDao,
    private val sp: SharedPreferences,
) {

    suspend fun updateUserList(userList: List<UserEntity>) = userListDao.insertAll(users = userList)

    fun getUserListWithPagination(
        params: UpdateUserListParams,
    ): PagingSource<Int, UserEntity> = userListDao.pagingSource(
        gender = params.gender,
        nat = params.nat,
    )

    suspend fun getUserById(id: Long) = userListDao.getUserById(id = id)

    fun saveGender(gender: String) = sp.edit {
        putString(GENDER_KEY, gender)
    }

    fun saveNationality(nationality: String) = sp.edit {
        putString(NATIONALITY_KEY, nationality)
    }

    fun getGender(): String? = sp.getString(GENDER_KEY, null)

    fun getNationality(): String? = sp.getString(NATIONALITY_KEY, null)

    private companion object {
        
        const val GENDER_KEY = "gender_key"
        const val NATIONALITY_KEY = "nationality_key"
    }
}