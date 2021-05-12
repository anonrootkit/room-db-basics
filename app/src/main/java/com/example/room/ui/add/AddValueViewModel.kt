package com.example.room.ui.add

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.room.db.entities.WordEntity
import com.example.room.repo.WordsRepository
import kotlinx.coroutines.*

class AddValueViewModel(private val repository: WordsRepository) : ViewModel() {

    private val job = Job()
    private val scope = CoroutineScope(job + Dispatchers.Main)

    fun insert(string : String) {
        val wordEntity = WordEntity(string)

        scope.launch {
            withContext(Dispatchers.IO){
                repository.insert(wordEntity)
            }
        }
    }

    class Factory(private val repository: WordsRepository) : ViewModelProvider.Factory{
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return AddValueViewModel(repository) as T
        }
    }
}