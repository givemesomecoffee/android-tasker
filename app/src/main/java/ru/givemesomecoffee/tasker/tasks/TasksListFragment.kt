package ru.givemesomecoffee.tasker.tasks

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import io.reactivex.disposables.Disposable
import ru.givemesomecoffee.tasker.R
import ru.givemesomecoffee.tasker.data.local.db.TaskRoom
import ru.givemesomecoffee.tasker.tasks.widget.TasksListAdapter

class TasksListFragment : Fragment(R.layout.fragment_tasks_list) {
    private lateinit var buttonTaskAdd: MaterialButton
    private lateinit var recyclerView: RecyclerView
    private val viewModel: TasksListViewModel by viewModels()


    private fun init() {
        buttonTaskAdd = requireView().findViewById(R.id.button_task_add)
        recyclerView = requireView().findViewById(R.id.recyclerView)
        viewModel.tasks.observe(viewLifecycleOwner, { tasks -> setAdapter(tasks) })

    }

    private fun setAdapter(list: List<TaskRoom>) {
        Log.d("test", "fragment got data")
        Log.d("test", list.toString())
        recyclerView.adapter = TasksListAdapter(list)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        init()
        super.onViewCreated(view, savedInstanceState)
        buttonTaskAdd.setOnClickListener {
            findNavController().navigate(R.id.action_tasksList_to_singleTaskFragment)
        }

    }

}


