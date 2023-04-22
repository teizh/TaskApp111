package com.example.taskapp.ui.onBoard

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.taskapp.databinding.FragmentOnBoardingBinding
import com.example.taskapp.model.OnBoard
import com.example.taskapp.ui.onBoard.adapter.OnBoardingAdapter
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator
import me.relex.circleindicator.CircleIndicator3


class OnBoardingFragment : Fragment() {
    private lateinit var binding: FragmentOnBoardingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // showToast("Message")
        val adapter = OnBoardingAdapter(this::onClick)
        binding.viewPager.adapter = adapter

        binding.indicator.setViewPager(binding.viewPager)

      /*  val viewpager: ViewPager2 = view.findViewById(R.id.view_pager)
        viewpager.adapter = adapter
        val indicator: CircleIndicator3 = view.findViewById(R.id.indicator)
        indicator.setViewPager(viewpager)
        */

        //val viewPager = requireActivity().findViewById<ViewPager2>(com.example.taskapp.R.id.view_pager)
        //  val dotsIndicator = requireActivity().findViewById<DotsIndicator>(com.example.taskapp.R.id.spring_dots_indicator)
        //  val tabLayout = view.findViewById(com.example.taskapp.R.id.tab_layout) as TabLayout
        // tabLayout.setupWithViewPager(viewPager, true)
        // dotsIndicator.setViewPager2(viewPager)
        //  dotsIndicator.setViewPager2(binding.viewPager)
    }

    private fun onClick(onBoard: OnBoard) {
        findNavController().navigateUp()
    }
}