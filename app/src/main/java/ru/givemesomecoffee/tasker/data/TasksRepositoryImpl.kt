package ru.givemesomecoffee.tasker.data

import io.reactivex.Flowable
import ru.givemesomecoffee.tasker.data.local.db.DB
import ru.givemesomecoffee.tasker.data.local.db.TaskRoom

class TasksRepositoryImpl: TasksRepository {
    private val db = DB.instance

   override fun getTasks(): Flowable<List<TaskRoom>>{
        return db.tasksDao().getTasks()
    }

    override fun searchTasks(query: String): Flowable<List<TaskRoom>> {
        return db.tasksDao().searchTasks("%$query%")
    }

}