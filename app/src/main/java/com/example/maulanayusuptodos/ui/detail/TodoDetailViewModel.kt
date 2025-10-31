package com.example.maulanayusuptodos.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.maulanayusuptodos.data.model.Todo
import com.example.maulanayusuptodos.data.repository.TodoRepository
import kotlinx.coroutines.launch

class TodoDetailViewModel : ViewModel() {
    private val repo = TodoRepository()
    private val _todo = MutableLiveData<Todo>()
    val todo: LiveData<Todo> = _todo

    fun fetchTodoDetail(id: Int) {
        viewModelScope.launch {
            val response = repo.getTodoDetail(id)
            if (response.isSuccessful) {
                _todo.value = response.body()
            }
        }
    }
}