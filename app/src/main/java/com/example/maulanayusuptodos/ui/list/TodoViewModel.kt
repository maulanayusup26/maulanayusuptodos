package com.example.maulanayusuptodos.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.maulanayusuptodos.data.model.Todo
import com.example.maulanayusuptodos.data.repository.TodoRepository
import kotlinx.coroutines.launch

class TodoViewModel : ViewModel() {
    private val repo = TodoRepository()
    private val _todos = MutableLiveData<List<Todo>>()
    val todos: LiveData<List<Todo>> = _todos

    fun fetchTodos() {
        viewModelScope.launch {
            val response = repo.getTodos()
            if (response.isSuccessful) {
                _todos.value = response.body()
            }
        }
    }
}