package ru.givemesomecoffee.tasker.data.local.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class TaskRoom(

    @PrimaryKey(autoGenerate = true)
    val id: Long?,

    val title: String,

    val description: String?

)