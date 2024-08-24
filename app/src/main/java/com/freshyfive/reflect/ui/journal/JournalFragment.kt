package com.freshyfive.reflect.ui.journal

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.freshyfive.reflect.R
import com.freshyfive.reflect.database.JournalDao
import com.freshyfive.reflect.database.JournalDatabase
import com.freshyfive.reflect.database.JournalEntity
import com.freshyfive.reflect.database.Mood
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Calendar

class JournalFragment : Fragment() {

    private lateinit var dao: JournalDao

//    companion object {
//        fun newInstance() = JournalFragment()
//    }

    private val viewModel: JournalViewModel by viewModels()
    private lateinit var journalAdapter: JournalAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val journalRecyclerView = view.findViewById<RecyclerView>(R.id.journalRecyclerView)
        val newNoteBtn = view.findViewById<FloatingActionButton>(R.id.addNewNote)

//        val list = listOf(
//            JournalEntity(
//                id = 1,
//                mood = Mood.ANGRY,
//                title = "Test Journal",
//                mainText = "jkrficrhrejijr",
//                createdAt = Calendar.getInstance().time,
//                isStarred = false
//            ),
//            JournalEntity(
//                id = 2,
//                mood = Mood.ANGRY,
//                title = "Test Journal",
//                mainText = "jkrficrhrejijr",
//                createdAt = Calendar.getInstance().time,
//                isStarred = false
//            ),
//            JournalEntity(
//                id = 3,
//                mood = Mood.ANGRY,
//                title = "Test Journal",
//                mainText = "jkrficrhrejijr",
//                createdAt = Calendar.getInstance().time,
//                isStarred = false
//            )
//        )
        dao = JournalDatabase.getDatabase(requireContext()).journalDao()

        journalAdapter = JournalAdapter(mutableListOf())

        journalRecyclerView.adapter = journalAdapter
        journalRecyclerView.layoutManager = GridLayoutManager(view.context, 2)

        loadJournalEntries()

        newNoteBtn.setOnClickListener {
            val i = Intent(view.context, NewJournalActivity::class.java)
            startActivity(i)
        }
    }

    private fun loadJournalEntries() {
        CoroutineScope(Dispatchers.IO).launch {
            val journals = dao.getAllJournals().toMutableList()
            withContext(Dispatchers.Main) {
                journalAdapter.updateData(journals)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.d("DEBUG", "OnCreateView called")
        return inflater.inflate(R.layout.fragment_journal, container, false)
    }
}

//}