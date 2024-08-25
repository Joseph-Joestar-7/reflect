package com.freshyfive.reflect.ui.recommendationsate

import android.content.Intent
//import RecommendationsViewModel

import androidx.fragment.app.viewModels
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.freshyfive.reflect.R
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
import com.freshyfive.reflect.models.getMood
import com.freshyfive.reflect.models.getProfession
import com.freshyfive.reflect.ui.recommendations.items.ArticleItemsActivity
import com.freshyfive.reflect.ui.recommendations.items.BooksItemsActivity
import com.freshyfive.reflect.ui.recommendations.items.MoviesItemsActivity
import com.freshyfive.reflect.ui.recommendations.items.MusicItemsActivity
import com.freshyfive.reflect.ui.recommendations.items.ShortfilmItemsActivity

class RecommendationsFragment : Fragment() {

//    private val viewModel: RecommendationsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_recommendations, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val articlesTab = view.findViewById<View>(R.id.ArticlesTab)
        val booksTab = view.findViewById<View>(R.id.BooksTab)
        val moviesTab = view.findViewById<View>(R.id.MoviesTab)
        val musicTab = view.findViewById<View>(R.id.MusicTab)
        val shortFilmTab = view.findViewById<View>(R.id.ShortFilmTab)

        val mood = getMood(view.context)?.uppercase()
        val profession = getProfession(view.context)
        Log.d("DEBUG", "Mood: $mood, Profession: $profession")


        articlesTab.setOnClickListener {
            val i = Intent(view.context, ArticleItemsActivity::class.java)
//            val list = getLists(mood, profession, "Articles")
//            i.putStringArrayListExtra("list",viewModel.articleList)
            startActivity(i)
        }
        booksTab.setOnClickListener {
            val i = Intent(view.context, BooksItemsActivity::class.java)
            val list = getLists(mood, profession, "Books").mapNotNull { it as? String }.shuffled().take(3)
            i.putStringArrayListExtra("list", ArrayList(list))
            startActivity(i)
        }
        moviesTab.setOnClickListener {
            val i = Intent(view.context, MoviesItemsActivity::class.java)
            val list = getLists(mood, profession, "Movies").mapNotNull { it as? String }.shuffled().take(3)
            i.putStringArrayListExtra("list",ArrayList(list))
            startActivity(i)
        }
        musicTab.setOnClickListener {
            val i = Intent(view.context, MusicItemsActivity::class.java)
            val list = getLists(mood, profession, "Music").mapNotNull { it as? String }.shuffled().take(3)
            i.putStringArrayListExtra("list",ArrayList(list))
            startActivity(i)
        }
        shortFilmTab.setOnClickListener {
            val i = Intent(view.context, ShortfilmItemsActivity::class.java)
            val list = getLists(mood, profession, "Short Films").mapNotNull { it as? String }.shuffled().take(3)
            i.putStringArrayListExtra("list",ArrayList(list))
            startActivity(i)
        }
    }

    private fun getLists(mood: String?, profession: String?, listType: String): List<Any> {
        when (profession) {
            "Student" -> {
                when(listType) {
                    "Articles" -> {
                        return studentArticleList[mood]?: emptyList()
                    }
                    "Books" -> {
                        return studentBookList[mood]?: emptyList()
                    }
                    "Movies" -> {
                        return studentMovieList[mood]?: emptyList()
                    }
                    "Music" -> {
                        return studentMusicList[mood]?: emptyList()
                    }
                    "Short Films" -> {
                        return studentShortFilmList[mood] ?: emptyList()
                    }
                }
            }
            "Professional Working Class" -> {
                when(listType) {
                    "Articles" -> {
                        return professionalArticleList[mood]?: emptyList()
                    }
                    "Books" -> {
                        return professionalBookList[mood] ?: emptyList()
                    }
                    "Movies" -> {
                        return professionalMovieList[mood] ?: emptyList()
                    }
                    "Music" -> {
                        return professionalMusicList[mood] ?: emptyList()
                    }
                    "Short Films" -> {
                        return professionalShortFilmList[mood] ?: emptyList()
                    }
                }
            }
            "Retired" -> {
                when(listType) {
                    "Articles" -> {
                        return retiredArticleList[mood]?: emptyList()
                    }
                    "Books" -> {
                        return retiredBookList[mood] ?: emptyList()
                    }
                    "Movies" -> {
                        return retiredMovieList[mood] ?: emptyList()
                    }
                    "Music" -> {
                        return retiredMusicList[mood] ?: emptyList()
                    }
                    "Short Films" -> {
                        return retiredShortFilmList[mood] ?: emptyList()
                    }
                }

            }
            else -> {
                return emptyList()
            }
        }
        return emptyList()
    }
}