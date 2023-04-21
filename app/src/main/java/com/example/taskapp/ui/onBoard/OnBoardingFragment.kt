package com.example.taskapp.ui.onBoard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import com.example.taskapp.R
import com.example.taskapp.databinding.FragmentOnBoardingBinding
import com.example.taskapp.model.OnBoard
import com.example.taskapp.ui.onBoard.adapter.OnBoardingAdapter
import com.example.taskapp.utils.showToast
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator

class OnBoardingFragment : Fragment() {
    private lateinit var binding: FragmentOnBoardingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // showToast("Message")
        val adapter = OnBoardingAdapter(this::onClick)
        binding.viewPager.adapter = adapter
        val dotsIndicator = requireActivity().findViewById<DotsIndicator>(R.id.spring_dots_indicator)
        val viewPager = requireActivity().findViewById<ViewPager>(R.id.view_pager)
      //dotsIndicator.setViewPager(viewPager)
          // dotsIndicator.setViewPager2(binding.viewPager.findViewById(R.id.view_pager  ))
    }

    private fun onClick(onBoard: OnBoard) {
        findNavController().navigateUp()
    }
}