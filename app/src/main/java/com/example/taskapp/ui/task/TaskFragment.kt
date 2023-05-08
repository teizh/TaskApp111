package com.example.taskapp.ui.task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.example.taskapp.App
import com.example.taskapp.model.Task
import com.example.taskapp.databinding.FragmentTaskBinding


class TaskFragment : Fragment() {
    private lateinit var binding: FragmentTaskBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSave.setOnClickListener {
            save()
        }
    }

    private fun save() {
        val data = Task(
            title = binding.etTitle.text.toString(),
            desc = binding.etDescription.text.toString()
        )
        App.db.taskDao().insert(data)
        //setFragmentResult(TASK_REQUEST, bundleOf(TASK_KEY to data))
        findNavController().navigateUp()
    }

    companion object {
        const val TASK_REQUEST = "task.requestKey"
        const val TASK_KEY = "task.key"
    }
}
