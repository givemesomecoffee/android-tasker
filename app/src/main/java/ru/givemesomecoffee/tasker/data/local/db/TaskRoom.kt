package ru.givemesomecoffee.tasker.data.local.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "tasks")
data class TaskRoom(

    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,

    val title: String,

    val description: String? = null,

  //  val finishDate: Date? = null,

    val tag: String? = null

)