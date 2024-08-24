package com.freshyfive.reflect.ui.dailytasks

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.freshyfive.reflect.R
import com.freshyfive.reflect.database.TaskEntity

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
            TaskEntity(
                "Go for a walk",
                false
            ),
            TaskEntity(
                "Meditate",
                false
            ),
        )

        taskRecyclerView.adapter = DailyTaskAdapter(list)
        taskRecyclerView.layoutManager = LinearLayoutManager(view.context)
    }
}