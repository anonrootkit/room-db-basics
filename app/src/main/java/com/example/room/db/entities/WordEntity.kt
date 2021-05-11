package com.example.room.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(tableName = "words")
data class WordEntity(
    @ColumnInfo(name = "message")
    val message : String
)