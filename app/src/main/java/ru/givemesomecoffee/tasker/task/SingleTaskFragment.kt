package ru.givemesomecoffee.tasker.task

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout
import ru.givemesomecoffee.tasker.R
import ru.givemesomecoffee.tasker.data.local.db.DB
import ru.givemesomecoffee.tasker.data.local.db.TaskRoom

class SingleTaskFragment : Fragment(R.layout.fragment_single_task) {
    private lateinit var editTaskTitleView: TextInputLayout
    private lateinit var editTaskDescriptionView: TextInputLayout
    private lateinit var editTaskConfirmButton: MaterialButton
    private val db = DB.instance

    private fun init() {
        editTaskTitleView = requireView().findViewById(R.id.edit_task_title_view)
        editTaskDescriptionView = requireView().findViewById(R.id.edit_task_description_view)
        editTaskConfirmButton = requireView().findViewById(R.id.button)

        editTaskConfirmButton.setOnClickListener {
            db.tasksDao().addTask(
                TaskRoom(
                    null,
                    editTaskTitleView.editText?.text.toString(),
                    editTaskDescriptionView.editText?.text.toString()
                )
            )
            findNavController().popBackStack()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        init()
        super.onViewCreated(view, savedInstanceState)
    }

}