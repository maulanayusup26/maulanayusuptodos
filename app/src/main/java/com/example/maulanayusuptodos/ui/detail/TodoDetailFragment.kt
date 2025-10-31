package com.example.maulanayusuptodos.ui.detail

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.maulanayusuptodos.databinding.FragmentTodoDetailBinding

class TodoDetailFragment : Fragment() {
    private var _binding: FragmentTodoDetailBinding? = null
    private val binding get() = _binding!!
    private val args: TodoDetailFragmentArgs by navArgs()
    private val viewModel: TodoDetailViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentTodoDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.fetchTodoDetail(args.todoId)
        viewModel.todo.observe(viewLifecycleOwner) { todo ->
            binding.textId.text = "ID: ${todo.id}"
            binding.textTitle.text = todo.title
            binding.textStatus.text = if (todo.completed) "✅ Completed" else "❌ Not Completed"
        }
    }
}
