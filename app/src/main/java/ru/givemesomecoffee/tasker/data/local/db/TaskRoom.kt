package ru.givemesomecoffee.tasker.data.local.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class TaskRoom(

    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,

    val title: String,

    val description: String? = null,

    //  val finishDate: Date? = null,

    val tag: String? = null,

    val isFinished: Boolean = false,

    val isArchived: Boolean = false

)