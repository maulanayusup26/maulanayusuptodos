package com.example.maulanayusuptodos.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.maulanayusuptodos.data.model.Todo
import com.example.maulanayusuptodos.databinding.ItemTodoBinding

class TodoAdapter(
    private var todoList: List<Todo>,
    private val onItemClick: (Todo) -> Unit
) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    inner class TodoViewHolder(private val binding: ItemTodoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(todo: Todo) {
            binding.tvTitle.text = todo.title

            // Klik item -> kirim ke fragment detail
            binding.root.setOnClickListener {
                onItemClick(todo)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val binding = ItemTodoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TodoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.bind(todoList[position])
    }

    override fun getItemCount(): Int = todoList.size

    // Optional: biar bisa update data dari fragment
    fun updateData(newList: List<Todo>) {
        todoList = newList
        notifyDataSetChanged()
    }
}
