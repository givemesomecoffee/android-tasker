package ru.givemesomecoffee.tasker.data.local.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface TasksDao {

    @Query("SELECT * from tasks")
    fun getTasks(): Flowable<List<TaskRoom>>

    @Insert
    fun addTask(taskRoom: TaskRoom): Completable

    @Update
    fun updateTask(taskRoom: TaskRoom): Int
}