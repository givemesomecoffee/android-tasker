package ru.givemesomecoffee.tasker.tasks

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import ru.givemesomecoffee.tasker.R
import ru.givemesomecoffee.tasker.data.local.db.DB
import ru.givemesomecoffee.tasker.tasks.widget.TasksListAdapter

class TasksList : Fragment(R.layout.fragment_tasks_list) {
    private lateinit var buttonTaskAdd: MaterialButton
    private lateinit var recyclerView: RecyclerView
    private val db = DB.instance

    private fun init() {
        buttonTaskAdd = requireView().findViewById(R.id.button_task_add)
        recyclerView = requireView().findViewById(R.id.recyclerView)
        recyclerView.adapter = TasksListAdapter(db.tasksDao().getTasks())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        init()
        super.onViewCreated(view, savedInstanceState)
        buttonTaskAdd.setOnClickListener {
            findNavController().navigate(R.id.action_tasksList_to_singleTaskFragment)
        }
    }

}


