package com.freshyfive.reflect.ui.recommendations

import com.freshyfive.reflect.data.Article

data class RecommendationsUIState (
    val articleList: List<Article> = emptyList(),
    val booklist: List<String> = emptyList(),
    val movielist: List<String> = emptyList(),
    val musicList: List<String> = emptyList(),
    val shortFilmList: List<String> = emptyList()
)