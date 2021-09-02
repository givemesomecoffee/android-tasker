package ru.givemesomecoffee.tasker.task

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputLayout
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import ru.givemesomecoffee.tasker.R
import ru.givemesomecoffee.tasker.data.local.db.DB
import ru.givemesomecoffee.tasker.data.local.db.TaskRoom

class SingleTaskFragment : Fragment(R.layout.fragment_single_task) {
    private lateinit var editTaskTitleView: TextInputLayout
    private lateinit var editTaskDescriptionView: TextInputLayout
    private lateinit var editTaskConfirmButton: MaterialButton
    private lateinit var disposable: Disposable
    private val db = DB.instance

    private fun init() {
        editTaskTitleView = requireView().findViewById(R.id.edit_task_title_view)
        editTaskDescriptionView = requireView().findViewById(R.id.edit_task_description_view)
        editTaskConfirmButton = requireView().findViewById(R.id.button)

        editTaskConfirmButton.setOnClickListener {
            val task = TaskRoom(
                null,
                editTaskTitleView.editText?.text.toString(),
                editTaskDescriptionView.editText?.text.toString()
            )
            saveTask(task)


        }
    }

    private fun saveTask(task: TaskRoom) {
       disposable = db.tasksDao().addTask(task)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(  { finish()  }, {error -> Log.d("rxjava2", error.toString())} )
    }

    private fun finish(){
        disposable.dispose()
        findNavController().popBackStack()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        init()
        super.onViewCreated(view, savedInstanceState)
    }

}