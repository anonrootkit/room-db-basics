package com.example.room.repo

import androidx.lifecycle.LiveData
import com.example.room.db.dao.WordsDao
import com.example.room.db.entities.WordEntity

class WordsRepository(private val wordsDao: WordsDao) {
    val wordsData : LiveData<List<WordEntity>> = wordsDao.getAllWords()

    suspend fun insert(word: WordEntity) {
        wordsDao.insertWord(word)
    }
}