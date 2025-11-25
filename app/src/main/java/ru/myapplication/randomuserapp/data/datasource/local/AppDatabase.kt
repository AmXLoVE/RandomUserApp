package ru.myapplication.randomuserapp.data.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import ru.myapplication.randomuserapp.data.datasource.local.model.UserEntity

@Database(
    entities = [UserEntity::class],
    version = 1,
)
@TypeConverters(Converters::class)
internal abstract class AppDatabase : RoomDatabase() {

    abstract fun userListDao(): UserListDao
}