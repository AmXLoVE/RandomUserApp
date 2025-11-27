package ru.myapplication.randomuserapp.data.datasource.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import ru.myapplication.randomuserapp.data.datasource.local.model.UserEntity

@Dao
internal interface UserListDao {

    @Query("SELECT * FROM userentity WHERE (:gender IS NULL OR gender = :gender) AND (:nat IS NULL OR nat = :nat) ORDER by id ASC")
    fun pagingSource(
        gender: String?,
        nat: String?,
    ): PagingSource<Int, UserEntity>

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(users: List<UserEntity>)

    @Query("SELECT * FROM userentity WHERE id = :id")
    suspend fun getUserById(id: Long): UserEntity?
}