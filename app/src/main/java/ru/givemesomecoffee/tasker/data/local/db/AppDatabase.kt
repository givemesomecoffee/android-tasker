package ru.givemesomecoffee.tasker.data.local.db

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.givemesomecoffee.tasker.App

@Database(entities = [TaskRoom::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun tasksDao(): TasksDao
}

object DB {
    val instance = createDb()

    private fun createDb(): AppDatabase {
        return Room.databaseBuilder(
            App.appContext,
            AppDatabase::class.java,
            "test"

        ).fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }


}