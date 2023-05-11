package com.example.taskapp.ui.task

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.room.Update
import com.example.taskapp.App
import com.example.taskapp.model.Task
import com.example.taskapp.databinding.FragmentTaskBinding


class TaskFragment : Fragment() {
    private lateinit var binding: FragmentTaskBinding
    private var task: Task? = null
//val args:TaskFragment by navArgs()
  private lateinit var navArgs: TaskFragmentArgs
    //private lateinit var navArgs: TaskFragment
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
            task = navArgs.task
        }
        if (task != null){
            binding.etTitle.setText(task?.title)
            binding.etDescription.setText(task?.desc1)
            binding.btnSave.text = "Update"
        }else{
            binding.btnSave.text = "Save"
        }
        binding.btnSave.setOnClickListener {
            Log.e("uuu", "item opened")
            Log.i("uuu", "playerString")
            if(task!= null){
                update()
            }//else save()
        }

    }

    private fun save() {
        val data = Task(
            title = binding.etTitle.text.toString(),
            desc1 = binding.etDescription.text.toString()
        )
        App.db.taskDao().insert(data)
        //setFragmentResult(TASK_REQUEST, bundleOf(TASK_KEY to data))
        findNavController().navigateUp()
    }

    private fun update() {

        //binding.etTitle.text.clear()
        //binding.etDescription.text.clear()
        /*  App.db.taskDao().update(
             titleUpdated = binding.etTitle.text.toString(),
             descUpdated = binding.etDescription.text.toString(),
             idUpdated = id
         )*/

        task?.title = binding.etTitle.text.toString()
        task?.desc1 = binding.etDescription.text.toString()

      //  task?.let { App.db.taskDao().delete(it) }
        findNavController().navigateUp()
        Log.e("123", "updating")
    }

    companion object {
        const val TASK_REQUEST = "task.requestKey"
        const val TASK_KEY = "task.key"
    }
}
