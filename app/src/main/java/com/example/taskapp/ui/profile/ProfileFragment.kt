package com.example.taskapp.ui.profile

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import com.example.taskapp.data.local.Pref
import com.example.taskapp.databinding.FragmentProfileBinding
import com.example.taskapp.utils.loadImage


class ProfileFragment : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private lateinit var pref: Pref


    private val pickMedia = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK
            && result.data != null
        ) {
            val uri = result.data?.data
            pref.saveProfileImage(uri.toString())
            binding.profileImage.loadImage(uri.toString())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
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
        binding.profileImage.setOnLongClickListener {
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            pickMedia.launch(intent)
            //  pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
            false
        }
        /*   binding.profileImage.setCircleBackgroundColorResource(pref.getUserProfilePic())
      binding.profileImage.setImageDrawable {
             pref.saveUserProfilePic(binding.profileImage.int)
         }*/
    }
}


