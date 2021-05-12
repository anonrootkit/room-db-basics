package com.example.room.ui.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.room.R
import com.example.room.databinding.FragmentAddValueBinding
import com.example.room.db.OurDatabase
import com.example.room.repo.WordsRepository

class AddValueFragment : Fragment(){
    private lateinit var binding : FragmentAddValueBinding
    private lateinit var viewModel : AddValueViewModel

    private lateinit var ourDB : OurDatabase
    private lateinit var repository: WordsRepository

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
        ourDB = OurDatabase.getDatabase(requireContext())
        repository = WordsRepository(ourDB.wordDao())

        viewModel = ViewModelProvider(this, AddValueViewModel.Factory(repository)).get(AddValueViewModel::class.java)

        binding.addValueButton.setOnClickListener {
            val string = binding.valueEditText.text.toString()
            viewModel.insert(string)
            findNavController().navigate(R.id.action_addValueFragment_to_homeFragment)
        }
    }
}