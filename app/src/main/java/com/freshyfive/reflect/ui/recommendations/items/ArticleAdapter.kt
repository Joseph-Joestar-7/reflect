package com.freshyfive.reflect.ui.recommendations.items

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.freshyfive.reflect.R
import com.freshyfive.reflect.data.Article

class ArticleAdapter(private val list: List<Article>) : RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {
    inner class ArticleViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val articleHeading: TextView = view.findViewById(R.id.ArticleHeading)
        val articleContent: TextView = view.findViewById(R.id.ArticleContent)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.article_items, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.articleHeading.text = list[position].articleText
        holder.articleContent.text = list[position].articleName
    }
}