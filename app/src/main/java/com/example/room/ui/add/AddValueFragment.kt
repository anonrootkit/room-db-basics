package com.example.room.ui.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.room.R
import com.example.room.databinding.FragmentAddValueBinding

class AddValueFragment : Fragment(){
    private lateinit var binding : FragmentAddValueBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddValueBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addValueButton.setOnClickListener {
            findNavController().navigate(R.id.action_addValueFragment_to_homeFragment)
        }
    }
}