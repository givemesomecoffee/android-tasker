package ru.givemesomecoffee.tasker.task.search

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.PublishSubject
import ru.givemesomecoffee.tasker.R
import ru.givemesomecoffee.tasker.di.AppComponent
import ru.givemesomecoffee.tasker.task.widget.TasksListAdapter
import java.util.concurrent.TimeUnit

class TaskSearchFragment : Fragment(R.layout.fragment_task_search) {

    private var tasksListAdapter: TasksListAdapter? = null
    private lateinit var inputTaskSearch: TextInputLayout
    private lateinit var searchTasksRecyclerView: RecyclerView
    private lateinit var inputTextSearchTask: TextInputEditText
    private var performSearchTasksDisposable: Disposable? = null
    private var searchDisposable: Disposable? = null

    private fun init() {
        inputTaskSearch = requireView().findViewById(R.id.input_task_search)
        searchTasksRecyclerView = requireView().findViewById(R.id.search_tasks_list)
        inputTextSearchTask = requireView().findViewById(R.id.search_task_text_input)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        init()
        val searchObservable: PublishSubject<Any> = PublishSubject.create()
        inputTextSearchTask.doOnTextChanged { text, start, before, count ->
            searchObservable.onNext(
                text.toString()
            )
        }

        searchDisposable = searchObservable
            .debounce(300, TimeUnit.MILLISECONDS)
            .distinctUntilChanged()
            .subscribe {
                Log.d("searchDisposable", it.toString())
                searchTasks(it.toString())
            }

        super.onViewCreated(view, savedInstanceState)
    }

    private fun searchTasks(string: String) {
        performSearchTasksDisposable?.dispose()
        performSearchTasksDisposable = AppComponent.repository.searchTasks(string)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                Log.d("searchTasks", it.toString())
                searchTasksRecyclerView.adapter = TasksListAdapter(it)

            }
        // Log.d("disposables", disposables.size().toString())
    }

    override fun onDestroyView() {
        searchDisposable?.dispose()
        performSearchTasksDisposable?.dispose()
        super.onDestroyView()
    }

}