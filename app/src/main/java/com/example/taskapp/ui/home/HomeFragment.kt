package com.example.taskapp.ui.home

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.taskapp.App
import com.example.taskapp.R
import com.example.taskapp.databinding.FragmentHomeBinding
import com.example.taskapp.model.Task
import com.example.taskapp.ui.home.adapter.TaskAdapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val adapter = TaskAdapter(onLongClick = this::onLongClick, onClick = this::onClick)



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return _binding?.root ?: binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = adapter
        /*setFragmentResultListener(TaskFragment.TASK_REQUEST) { _, bundle ->
            val result = bundle.getSerializable(TaskFragment.TASK_KEY) as Task
            Log.e("ololo", "onViewCreated: $result")
            adapter.addTask(result)
        }*/
        setData()
        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.taskFragment)
        }
    }

    private fun onLongClick(task: Task) {
        val alertDialog = AlertDialog.Builder(requireContext())
        alertDialog.setTitle("Do you want to delete info?")
        alertDialog.setNegativeButton("No", object : DialogInterface.OnClickListener {
            override fun onClick(dialog: DialogInterface?, which: Int) {
                dialog?.cancel()
            }
        })
        alertDialog.setPositiveButton("Yes", object : DialogInterface.OnClickListener {
            override fun onClick(dialog: DialogInterface?, which: Int) {
                App.db.taskDao().delete(task)
                setData()
            }
        })
        alertDialog.create().show()
    }

    private fun onClick(task: Task) {
        Log.e("123", "onClick ")
        findNavController().navigate(R.id.taskFragment)

    }
    private fun setData(){
        val list = App.db.taskDao().getAll()
        adapter.addTasks(list)
    }
}