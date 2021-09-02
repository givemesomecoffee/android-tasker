package ru.givemesomecoffee.tasker.tasks

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import ru.givemesomecoffee.tasker.data.local.db.DB
import ru.givemesomecoffee.tasker.data.local.db.TaskRoom

class TasksListViewModel : ViewModel() {
    private val tasksDao = DB.instance.tasksDao()
   // private val tasksAsync: Disposable =
     //   tasksDao.getTasks().subscribeOn(Schedulers.io()).subscribe { list -> setNewTasksList(list) }
    private val _tasks: MutableLiveData<List<TaskRoom>> = MutableLiveData()
    val tasks get() = _tasks

    init {
        getNewTasksList()
    }

    fun getNewTasksList() {
        val tasksAsync1: Disposable =
            tasksDao.getTasks().subscribeOn(Schedulers.io()).subscribe { list -> setNewTasksList(list) }
Log.d("test", tasksAsync1.toString())
    }

    private fun setNewTasksList(list: List<TaskRoom>) {
        Log.d("test", "set")
        _tasks.postValue(list)

    }

    override fun onCleared() {
       // tasksAsync.dispose()
        super.onCleared()
    }


}