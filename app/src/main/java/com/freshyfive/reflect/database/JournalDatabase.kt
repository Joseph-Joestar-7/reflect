package com.freshyfive.reflect.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [JournalEntity::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class JournalDatabase: RoomDatabase() {
    abstract fun journalDao(): JournalDao

    companion object {
        @Volatile
        private var Instance: JournalDatabase? = null

        fun getDatabase(context: Context): JournalDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, JournalDatabase::class.java, "month_database")
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }
}