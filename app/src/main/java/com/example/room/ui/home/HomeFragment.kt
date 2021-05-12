package com.example.room.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.room.R
import com.example.room.databinding.FragmentHomeBinding
import com.example.room.db.OurDatabase
import com.example.room.repo.WordsRepository
import com.example.room.ui.add.AddValueViewModel

class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding
    private lateinit var viewModel : HomeViewModel

    private lateinit var ourDB : OurDatabase
    private lateinit var repository: WordsRepository

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ourDB = OurDatabase.getDatabase(requireContext())
        repository = WordsRepository(ourDB.wordDao())

        viewModel = ViewModelProvider(this, HomeViewModel.Factory(repository)).get(HomeViewModel::class.java)

        binding.addValueFab.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_addValueFragment)
        }

        val wordsAdapter = ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1, ArrayList())

        binding.listView.apply {
            adapter = wordsAdapter
        }

        viewModel.wordsData.observe(viewLifecycleOwner){ wordsList ->
            if (wordsList != null){
                val tempList : ArrayList<String> = ArrayList()
                for (word in wordsList){
                    tempList.add(word.message)
                }

                wordsAdapter.clear()
                wordsAdapter.addAll(tempList)
                wordsAdapter.notifyDataSetChanged()
            }
        }
    }
}