package com.freshyfive.reflect.ui.recommendations.items

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.freshyfive.reflect.R
import com.freshyfive.reflect.database.ArticleEntity

class BookAdapter(private val list: List<String>) : RecyclerView.Adapter<BookAdapter.BookViewHolder>() {
    inner class BookViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val bookName: TextView = view.findViewById(R.id.BookName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        return BookViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.books_items, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bookName.text = list[position]
    }
}