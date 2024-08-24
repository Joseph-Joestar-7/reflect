package com.freshyfive.reflect.ui.journal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.freshyfive.reflect.R
import com.freshyfive.reflect.database.JournalDao
import com.freshyfive.reflect.database.JournalDatabase
import com.freshyfive.reflect.database.JournalEntity
import com.freshyfive.reflect.database.Mood
import com.freshyfive.reflect.ui.HomeActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Calendar

class NewJournalActivity : AppCompatActivity() {

    private lateinit var dao: JournalDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_new_journal)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        dao = JournalDatabase.getDatabase(this).journalDao()

        val saveJournal = findViewById<Button>(R.id.saveJournal)
        saveJournal.setOnClickListener {
            val journalTitle = findViewById<TextView>(R.id.journalTitle).text.toString()
            val journalMood = findViewById<Spinner>(R.id.journalMood).selectedItem.toString()
            val journalDesc = findViewById<EditText>(R.id.journalDesc).text.toString()

            val newJournal = JournalEntity(title = journalTitle, mainText = journalDesc, mood = Mood.valueOf(journalMood), createdAt = Calendar.getInstance().time, isStarred = false)
            CoroutineScope(Dispatchers.IO).launch {
                dao.insertJournal(newJournal)
            }
            Toast.makeText(this, "New note is added to journal.", Toast.LENGTH_SHORT).show()
            val i = Intent(this, HomeActivity::class.java)
            startActivity(i)
            finish()



        }
    }
}