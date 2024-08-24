package com.freshyfive.reflect.ui.recommendations

import androidx.lifecycle.ViewModel
import com.freshyfive.reflect.data.Article
import com.freshyfive.reflect.data.professionalArticleList
import com.freshyfive.reflect.data.professionalBookList
import com.freshyfive.reflect.data.professionalMovieList
import com.freshyfive.reflect.data.professionalMusicList
import com.freshyfive.reflect.data.professionalShortFilmList
import com.freshyfive.reflect.data.retiredArticleList
import com.freshyfive.reflect.data.retiredBookList
import com.freshyfive.reflect.data.retiredMovieList
import com.freshyfive.reflect.data.retiredMusicList
import com.freshyfive.reflect.data.retiredShortFilmList
import com.freshyfive.reflect.data.studentArticleList
import com.freshyfive.reflect.data.studentBookList
import com.freshyfive.reflect.data.studentMovieList
import com.freshyfive.reflect.data.studentMusicList
import com.freshyfive.reflect.data.studentShortFilmList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class RecommendationsViewModel(mood:String, profession:String) : ViewModel() {

    private val _uiState = MutableStateFlow(RecommendationsUIState())
    val uiState: StateFlow<RecommendationsUIState> = _uiState.asStateFlow()
    var articleList: List<Article> = emptyList()
    var booklist: List<String> = emptyList()
    var movielist: List<String> = emptyList()
    var musicList: List<String> = emptyList()
    var shortFilmList: List<String> = emptyList()
    fun loadRandomContent(){
        val articles=articleList.shuffled().take(1)
        val books=booklist.shuffled().take(3)
        val movies=movielist.shuffled().take(3)
        val music = musicList.shuffled().take(3)
        val shortfilms = shortFilmList.shuffled().take(3)
        _uiState.value = RecommendationsUIState(
            articleList =articles ,
            booklist=books,
            movielist =movies,
            musicList =music,
            shortFilmList = shortfilms
        )
    }

    init {
        when (profession) {
            "Student" -> {
                articleList= studentArticleList[mood]?: emptyList()
                booklist = studentBookList[mood] ?: emptyList()
                movielist = studentMovieList[mood] ?: emptyList()
                musicList = studentMusicList[mood] ?: emptyList()
                shortFilmList = studentShortFilmList[mood] ?: emptyList()
            }
            "Professional Working Class" -> {
                articleList= professionalArticleList[mood]?: emptyList()
                booklist = professionalBookList[mood] ?: emptyList()
                movielist = professionalMovieList[mood] ?: emptyList()
                musicList = professionalMusicList[mood] ?: emptyList()
                shortFilmList = professionalShortFilmList[mood] ?: emptyList()
            }
            "Retired" -> {
                articleList= retiredArticleList[mood]?: emptyList()
                booklist = retiredBookList[mood] ?: emptyList()
                movielist = retiredMovieList[mood] ?: emptyList()
                musicList = retiredMusicList[mood] ?: emptyList()
                shortFilmList = retiredShortFilmList[mood] ?: emptyList()
            }
            else -> {
                booklist = emptyList()
                movielist = emptyList()
                musicList = emptyList()
                shortFilmList = emptyList()
            }
        }
        loadRandomContent()
    }

}