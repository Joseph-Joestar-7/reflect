package com.freshyfive.reflect.ui.journal

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.freshyfive.reflect.R

class ExpandedJournalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expanded_journal)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        val journalHeaderText = findViewById<TextView>(R.id.journalHeaderText)
        val journalBodyText = findViewById<TextView>(R.id.journalBodyText)
        val journalDateText = findViewById<TextView>(R.id.journalDateText)

        journalHeaderText.text = intent.getStringExtra("journalHeader")
        journalBodyText.text = intent.getStringExtra("journalBody")
        journalDateText.text = intent.getStringExtra("journalDate")

    }
}