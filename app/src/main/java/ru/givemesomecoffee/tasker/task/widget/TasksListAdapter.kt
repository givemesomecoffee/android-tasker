package ru.givemesomecoffee.tasker.task.widget

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.givemesomecoffee.tasker.R
import ru.givemesomecoffee.tasker.data.local.db.TaskRoom

class TasksListAdapter(private val tasks: List<TaskRoom>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return TasksListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is TasksListViewHolder) holder.bind(tasks[position])
    }

    override fun getItemCount(): Int {
        return tasks.size
    }

}