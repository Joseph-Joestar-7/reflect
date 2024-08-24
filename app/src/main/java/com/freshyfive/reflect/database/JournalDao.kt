package com.freshyfive.reflect.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface JournalDao {
    @Query("SELECT * FROM journals ORDER BY isStarred DESC, id DESC")
    fun getAllJournals(): LiveData<List<JournalEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertJournal(journal: JournalEntity)

    @Delete
    suspend fun deleteJournal(journal: JournalEntity)

    @Query("UPDATE journals SET title = :newTitle WHERE id = :journalId")
    suspend fun updateTitle(journalId: Int, newTitle: String)

    @Query("UPDATE journals SET mainText = :newMainText WHERE id = :journalId")
    suspend fun updateMainText(journalId: Int, newMainText: String)

    @Query("UPDATE journals SET mood = :newMood WHERE id = :journalId")
    suspend fun updateMood(journalId: Int, newMood: Mood)

    @Query("UPDATE journals SET isStarred = :newIsStarred WHERE id = :journalId")
    suspend fun updateIsStarred(journalId: Int, newIsStarred: Boolean)

}