package com.freshyfive.reflect.ui.recommendationsate

import android.content.Intent
import com.freshyfive.reflect.ui.recommendations.RecommendationsViewModel

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.freshyfive.reflect.R
import com.freshyfive.reflect.ui.recommendations.items.ArticleItemsActivity
import com.freshyfive.reflect.ui.recommendations.items.BooksItemsActivity
import com.freshyfive.reflect.ui.recommendations.items.MoviesItemsActivity
import com.freshyfive.reflect.ui.recommendations.items.MusicItemsActivity
import com.freshyfive.reflect.ui.recommendations.items.ShortfilmItemsActivity

class RecommendationsFragment : Fragment() {

    private val viewModel: RecommendationsViewModel by viewModels()

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

        articlesTab.setOnClickListener {
            val i = Intent(view.context, ArticleItemsActivity::class.java)
//            i.putStringArrayListExtra("list",viewModel.articleList)
            startActivity(i)
        }
        booksTab.setOnClickListener {
            val i = Intent(view.context, BooksItemsActivity::class.java)
            i.putStringArrayListExtra("list",ArrayList(viewModel.booklist))
            startActivity(i)
        }
        moviesTab.setOnClickListener {
            val i = Intent(view.context, MoviesItemsActivity::class.java)
            i.putStringArrayListExtra("list",ArrayList(viewModel.movielist))
            startActivity(i)
        }
        musicTab.setOnClickListener {
            val i = Intent(view.context, MusicItemsActivity::class.java)
            i.putStringArrayListExtra("list",ArrayList(viewModel.musicList))
            startActivity(i)
        }
        shortFilmTab.setOnClickListener {
            val i = Intent(view.context, ShortfilmItemsActivity::class.java)
            i.putStringArrayListExtra("list",ArrayList(viewModel.shortFilmList))
            startActivity(i)
        }
    }
}