package com.freshyfive.reflect.ui.dailytasks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.freshyfive.reflect.R

class DailyTasksFragment : Fragment() {

    companion object {
        fun newInstance() = DailyTasksFragment()
    }

    private val viewModel: DailyTasksViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_daily_tasks, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val taskRecyclerView = view.findViewById<RecyclerView>(R.id.dailyTasksView)

        val list = listOf(
                "Go for a walk", "Meditate"
        )

        taskRecyclerView.adapter = DailyTaskAdapter(list)
        taskRecyclerView.layoutManager = LinearLayoutManager(view.context)
    }
}