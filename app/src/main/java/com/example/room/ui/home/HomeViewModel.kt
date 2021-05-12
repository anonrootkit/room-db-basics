package com.example.room.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.room.db.entities.WordEntity
import com.example.room.repo.WordsRepository
import kotlinx.coroutines.*

class HomeViewModel(private val repository: WordsRepository) : ViewModel() {

    val wordsData : LiveData<List<WordEntity>> = repository.wordsData

    class Factory(private val repository: WordsRepository) : ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return HomeViewModel(repository) as T
        }
    }
}