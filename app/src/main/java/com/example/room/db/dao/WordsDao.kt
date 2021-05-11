package com.example.room.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.room.db.entities.WordEntity

@Dao
interface WordsDao{
    @Insert
    suspend fun insertWord(wordEntity: WordEntity)

    @Query("SELECT * FROM words")
    fun getAllWords() : LiveData<List<WordEntity>>
}