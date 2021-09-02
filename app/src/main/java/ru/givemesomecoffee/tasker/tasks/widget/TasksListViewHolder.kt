package ru.givemesomecoffee.tasker.tasks.widget

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.givemesomecoffee.tasker.R
import ru.givemesomecoffee.tasker.data.local.db.TaskRoom

class TasksListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val taskTitleView: TextView = itemView.findViewById(R.id.item_task_title)
    private val taskDescriptionView: TextView = itemView.findViewById(R.id.item_task_description)

    fun bind(task: TaskRoom) {
        taskTitleView.text = task.title
        taskDescriptionView.text = task.description
    }
}