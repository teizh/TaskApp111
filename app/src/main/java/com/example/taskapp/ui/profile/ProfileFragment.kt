package com.example.taskapp.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.example.taskapp.data.local.Pref
import com.example.taskapp.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private lateinit var pref: Pref

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pref = Pref(requireContext())
        binding.etProfile.setText(pref.getUserName())
        binding.etProfile.addTextChangedListener {
            pref.saveUserName(binding.etProfile.text.toString())
        }
        /*   binding.profileImage.setCircleBackgroundColorResource(pref.getUserProfilePic())
      binding.profileImage.setImageDrawable {
             pref.saveUserProfilePic(binding.profileImage.int)
         }*/
    }
}

