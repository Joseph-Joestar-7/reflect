package com.freshyfive.reflect.ui.journal

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
import com.freshyfive.reflect.database.JournalEntity
import com.freshyfive.reflect.database.Mood
import java.util.Calendar

class JournalFragment : Fragment() {

//    private lateinit var dao: JournalDao

//    companion object {
//        fun newInstance() = JournalFragment()
//    }

    private val viewModel: JournalViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val journalRecyclerView = view.findViewById<RecyclerView>(R.id.journalRecyclerView)

        val list = listOf(
            JournalEntity(
                id = 1,
                mood = Mood.ANGRY,
                title = "Test Journal",
                mainText = "jkrficrhrejijr",
                createdAt = Calendar.getInstance().time,
                isStarred = false
            ),
            JournalEntity(
                id = 2,
                mood = Mood.ANGRY,
                title = "Test Journal",
                mainText = "jkrficrhrejijr",
                createdAt = Calendar.getInstance().time,
                isStarred = false
            ),
            JournalEntity(
                id = 3,
                mood = Mood.ANGRY,
                title = "Test Journal",
                mainText = "jkrficrhrejijr",
                createdAt = Calendar.getInstance().time,
                isStarred = false
            )
        )
//        dao = JournalDatabase.3getDatabase(requireContext()).journalDao()
        journalRecyclerView.adapter = JournalAdapter(list)
        journalRecyclerView.layoutManager = GridLayoutManager(view.context, 2)
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