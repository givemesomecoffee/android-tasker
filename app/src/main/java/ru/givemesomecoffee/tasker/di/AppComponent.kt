package ru.givemesomecoffee.tasker.di

import ru.givemesomecoffee.tasker.data.TasksRepository
import ru.givemesomecoffee.tasker.data.TasksRepositoryImpl

object AppComponent {
    val repository: TasksRepository = TasksRepositoryImpl()
}