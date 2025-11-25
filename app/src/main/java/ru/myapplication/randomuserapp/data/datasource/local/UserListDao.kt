package ru.myapplication.randomuserapp.data.datasource.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import ru.myapplication.randomuserapp.data.datasource.local.model.UserEntity

@Dao
internal interface UserListDao {

    @Query("SELECT * FROM userentity")
    fun getAll(): Flow<List<UserEntity>>

    @Insert
    fun insertAll(users: List<UserEntity>)
}