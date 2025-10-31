package com.example.maulanayusuptodos.ui.list

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.maulanayusuptodos.databinding.FragmentTodoListBinding

class TodoListFragment : Fragment() {
    private var _binding: FragmentTodoListBinding? = null
    private val binding get() = _binding!!
    private val viewModel: TodoViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentTodoListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.fetchTodos()
        viewModel.todos.observe(viewLifecycleOwner) { list ->
            binding.recyclerViewTodos.layoutManager = LinearLayoutManager(requireContext())
            binding.recyclerViewTodos.adapter = TodoAdapter(list) { todo ->
                val action = TodoListFragmentDirections.actionTodoListFragmentToTodoDetailFragment(todo.id)
                findNavController().navigate(action)
            }
        }
    }
}
