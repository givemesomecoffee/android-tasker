package ru.givemesomecoffee.tasker.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface TasksDao {

    @Query("SELECT * from tasks")
    fun getTasks(): List<TaskRoom>

    @Insert
    fun addTask(taskRoom: TaskRoom): Long

    @Update
    fun updateTask(taskRoom: TaskRoom): Int
}