package com.freshyfive.reflect.database

import androidx.lifecycle.LiveData

class JournalRepository(private val journalDao: JournalDao) {

    val allJournals: List<JournalEntity> = journalDao.getAllJournals()

    suspend fun insert(journal: JournalEntity) {
        journalDao.insertJournal(journal)
    }

    suspend fun delete(journal: JournalEntity) {
        journalDao.deleteJournal(journal)
    }

    suspend fun updateTitle(journalId: Int, newTitle: String) {
        journalDao.updateTitle(journalId, newTitle)
    }

    suspend fun updateMainText(journalId: Int, newMainText: String) {
        journalDao.updateMainText(journalId, newMainText)
    }

    suspend fun updateMood(journalId: Int, newMood: Mood) {
        journalDao.updateMood(journalId, newMood)
    }

    suspend fun updateIsStarred(journalId: Int, newIsStarred: Boolean) {
        journalDao.updateIsStarred(journalId, newIsStarred)
    }

}