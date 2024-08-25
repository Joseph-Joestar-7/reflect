package com.freshyfive.reflect.ui.dailytasks

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.freshyfive.reflect.R
import com.freshyfive.reflect.data.retiredtaskMap
import com.freshyfive.reflect.data.studenttaskMap
import com.freshyfive.reflect.data.workingtaskMap
import com.freshyfive.reflect.models.getMood
import com.freshyfive.reflect.models.getProfession

class DailyTasksFragment : Fragment() {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var tasksCompletedTextView: TextView
//    private lateinit var totalTasksTextView: TextView

    companion object {
        fun newInstance() = DailyTasksFragment()
    }

    private var completedTasks :Int=0
    private val totalTasks :Int=3

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_daily_tasks, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPreferences = view.context.getSharedPreferences("DailyTaskPrefs", Context.MODE_PRIVATE)

        val taskRecyclerView = view.findViewById<RecyclerView>(R.id.dailyTasksView)
        tasksCompletedTextView = view.findViewById(R.id.tasksCompletedTextView)
//        totalTasksTextView = view.findViewById(R.id.totalTasksTextView)


        val list = getDailyTasks() ?: emptyList()

        taskRecyclerView.adapter = DailyTaskAdapter(list) {
            completeTask()
        }
        taskRecyclerView.layoutManager = LinearLayoutManager(view.context)
        completedTasks = getCompletedTasksCount()
        updateTaskCounts()

    }

    private fun getTasks(mood: String?, profession: String?): List<String>? {
        when (profession) {
            "Student" -> {
                return studenttaskMap[mood]?.shuffled()?.take(3)
            }

            "Professional Working Class" -> {
                return workingtaskMap[mood]?.shuffled()?.take(3)
            }

            "Retired" -> {
                return retiredtaskMap[mood]?.shuffled()?.take(3)
            }

            else -> {
                return emptyList()
            }
        }
    }

    private fun completeTask() {
        if (completedTasks < totalTasks-1) {
            incrementCompletedTasks()
            addUserPoint()
            updateTaskCounts()
        }
    }

    private fun incrementCompletedTasks() {
        completedTasks = getCompletedTasksCount()
        sharedPreferences.edit()
            .putInt("completedTasks", completedTasks + 1)
            .apply()
    }

    private fun getDailyTasks(): List<String>? {
        val lastUpdated = sharedPreferences.getLong("lastUpdated", 0L)
        val currentTime = System.currentTimeMillis()

        // Check if 24 hours have passed since the last update
        return if (currentTime - lastUpdated >= 24 * 60 * 60 * 1000) {
            // Select 3 random tasks from the available tasks
            val newTasks = getTasks(getMood(requireContext())?.uppercase(), getProfession(requireContext()))
                ?.shuffled()
                ?.take(3)

            // Save the new tasks and update the timestamp
            sharedPreferences.edit()
                .putStringSet("dailyTasks", newTasks?.toSet())
                .putInt("completedTasks", 0) // Reset completed tasks count
                .putLong("lastUpdated", currentTime) // Update last updated time
                .apply()

            newTasks
        } else {
            sharedPreferences.getStringSet("dailyTasks", emptySet())?.toList()
        }
    }

    fun getCompletedTasksCount(): Int {
        return sharedPreferences.getInt("completedTasks", 0)
    }

    private fun updateTaskCounts() {
        val completedTasks = getCompletedTasksCount()
        val totalTasks = getTotalTasksCount()
        tasksCompletedTextView.text = "Tasks Completed: $completedTasks / $totalTasks"
    }

//    fun completeTask() {
//        val completedTasks = sharedPreferences.getInt("completedTasks", 0)
//        sharedPreferences.edit()
//            .putInt("completedTasks", completedTasks + 1)
//            .apply()
//    }

    fun getTotalTasksCount(): Int {
        return sharedPreferences.getStringSet("dailyTasks", emptySet())!!.size
    }

    fun getUserPoints(): Int {
        return sharedPreferences.getInt("userPoints", 0)
    }

    fun addUserPoint() {
        val userPoints = getUserPoints()
        sharedPreferences.edit()
            .putInt("userPoints", userPoints + 1)
            .apply()
    }


}