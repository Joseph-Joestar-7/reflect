package com.freshyfive.reflect.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "journals")
data class JournalEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int=0,
    val title: String,
    val mainText: String,
    val mood: Mood,
    val isStarred: Boolean,
    val createdAt: Date
)

enum class Mood {
    ANGRY, DEPRESSED, SAD, HAPPY, NEUTRAL
}