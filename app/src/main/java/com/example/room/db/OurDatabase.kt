package com.example.room.db

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.example.room.db.dao.WordsDao
import com.example.room.db.entities.WordEntity
import com.example.room.model.Word

@Database(entities = [WordEntity::class], version = 1, exportSchema = false)
abstract class OurDatabase : RoomDatabase() {

    abstract fun wordDao(): WordsDao

    companion object {
        // Singleton prevents multiple instances of database opening at the same time.

        @Volatile
        private var INSTANCE: OurDatabase? = null

        fun getDatabase(context: Context): OurDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    OurDatabase::class.java,
                    "word_database"
                ).build()

                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}