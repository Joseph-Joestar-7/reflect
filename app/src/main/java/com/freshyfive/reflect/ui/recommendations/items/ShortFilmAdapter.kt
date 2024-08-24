package com.freshyfive.reflect.ui.recommendations.items

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.freshyfive.reflect.R

class ShortFilmAdapter(private val list: List<String>) : RecyclerView.Adapter<ShortFilmAdapter.ShortFilmViewHolder>() {
    inner class ShortFilmViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val shortFilmName: TextView = view.findViewById(R.id.ShortfilmName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShortFilmViewHolder {
        return ShortFilmViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.music_items, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ShortFilmViewHolder, position: Int) {
        holder.shortFilmName.text = list[position]
    }
}