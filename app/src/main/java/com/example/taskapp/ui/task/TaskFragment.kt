package com.example.taskapp.ui.task

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.taskapp.App
import com.example.taskapp.model.Task
import com.example.taskapp.databinding.FragmentTaskBinding
class TaskFragment : Fragment() {
    private lateinit var binding: FragmentTaskBinding
    private var task1: Task? = null
    private lateinit var navArgs: TaskFragmentArgs
    private val bundle = arguments
    private val args = bundle?.let { TaskFragmentArgs.fromBundle(it) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            navArgs = TaskFragmentArgs.fromBundle(it)
            task1 = navArgs.task
        }
        if (task1 != null) {
            binding.etTitle.setText(args?.task?.title)
            binding.etDescription.setText(args?.task?.title)
            binding.btnSave.text = "Update"
        }else {
            binding.btnSave.text = "Save"
        }

        binding.btnSave.setOnClickListener {
            Log.e("uuu", "item opened")
            if (task1 != null) {
                update()
            } else save()
        }
    }

    private fun save() {
        Log.i("uuu", "string saved")
        val data = Task(
            title = binding.etTitle.text.toString(),
            desc1 = binding.etDescription.text.toString()
        )
        App.db.taskDao().insert(data)
        findNavController().navigateUp()
    }

    private fun update() {
        task1?.title = binding.etTitle.text.toString()
        task1?.desc1 = binding.etDescription.text.toString()
        task1?.let { App.db.taskDao().update(it) }
        findNavController().navigateUp()
    }

    companion object {
        const val TASK_REQUEST = "task.requestKey"
        const val TASK_KEY = "task.key"
    }
}
