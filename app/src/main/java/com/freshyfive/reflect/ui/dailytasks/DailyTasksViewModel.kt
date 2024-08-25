package com.freshyfive.reflect.ui.dailytasks

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.freshyfive.reflect.data.retiredtaskMap
import com.freshyfive.reflect.data.studenttaskMap
import com.freshyfive.reflect.data.workingtaskMap
import com.freshyfive.reflect.models.getMood
import com.freshyfive.reflect.models.getProfession
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DailyTasksViewModel(context:Context) : ViewModel() {
//    private val dailyTaskManager = DailyTaskManager(context)

//    private val _tasks = MutableStateFlow(dailyTaskManager.getDailyTasks())
//    val tasks: MutableStateFlow<List<String>?> = _tasks
////    val mood = getMood(context)?.uppercase()
////    private val profession = getProfession(context)
////    val taskSet=getTasks(mood,profession)
//    private val _completedTasksCount = MutableStateFlow(dailyTaskManager.getCompletedTasksCount())
//    val completedTasksCount: StateFlow<Int> = _completedTasksCount
//
//    val totalTasksCount: Int = dailyTaskManager.getTotalTasksCount()
//
//    fun completeTask(task: String) {
//        viewModelScope.launch {
//            dailyTaskManager.completeTask(task)
//            _completedTasksCount.value = dailyTaskManager.getCompletedTasksCount()
//        }
//    }
//
//    fun addUserPoint() {
//        viewModelScope.launch {
//            dailyTaskManager.addUserPoint()
//        }
    }


    class DailyTaskViewModelFactory(private val context: Context) : ViewModelProvider.Factory {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(DailyTasksViewModel::class.java)) {
                return DailyTasksViewModel(context) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }

