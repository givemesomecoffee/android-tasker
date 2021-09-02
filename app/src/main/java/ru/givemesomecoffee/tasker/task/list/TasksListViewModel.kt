package ru.givemesomecoffee.tasker.task.list

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import ru.givemesomecoffee.tasker.data.local.db.TaskRoom
import ru.givemesomecoffee.tasker.di.AppComponent

class TasksListViewModel : ViewModel() {
    private val tasksDao = AppComponent.repository
    private var tasksAsync: Disposable? = null
    private val _tasks: MutableLiveData<List<TaskRoom>> = MutableLiveData()
    val tasks get() = _tasks

    init {
        getNewTasksList()
    }

    override fun onCleared() {
        tasksAsync?.dispose()
        super.onCleared()
    }

    private fun getNewTasksList() {
        tasksAsync =
            tasksDao.getTasks().subscribeOn(Schedulers.io())
                .subscribe { list -> setNewTasksList(list) }
    }

    private fun setNewTasksList(list: List<TaskRoom>) {
        Log.d("test", "set")
        _tasks.postValue(list)
    }

}