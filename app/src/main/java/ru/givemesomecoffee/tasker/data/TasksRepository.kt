package ru.givemesomecoffee.tasker.data

import io.reactivex.Flowable
import ru.givemesomecoffee.tasker.data.local.db.TaskRoom

interface TasksRepository {

    fun getTasks(): Flowable<List<TaskRoom>>

    fun searchTasks(query: String): Flowable<List<TaskRoom>>
}