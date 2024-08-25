package com.freshyfive.reflect.ui.home

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.freshyfive.reflect.data.quotesList
import com.freshyfive.reflect.data.studenttaskMap
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel(private val context: Context) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeScreenUIState())
    val uiState: StateFlow<HomeScreenUIState> = _uiState.asStateFlow()

    init {
        loadRandomContent()
    }

    private fun loadRandomContent() {
        val mood = "DEPRESSED" // Replace with actual mood logic
        val dailyQuotes = quotesList[mood]?.shuffled()?.firstOrNull() ?: "No quote available"
        val dailyTips = studenttaskMap[mood]?.shuffled()?.firstOrNull() ?: "No tip available"

        _uiState.value = HomeScreenUIState(
            quote = dailyQuotes,
            dailyTip = dailyTips
        )
    }
}

// Factory class to create HomeViewModel with context
class HomeViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return HomeViewModel(context) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
