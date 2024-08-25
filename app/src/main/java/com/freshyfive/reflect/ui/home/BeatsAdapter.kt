package com.freshyfive.reflect.ui.home

import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.freshyfive.reflect.R

class BeatsAdapter(private val beats: List<Pair<String, String>>): RecyclerView.Adapter<BeatsAdapter.BeatsViewHolder>()  {
    inner class BeatsViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val beatName = view.findViewById<TextView>(R.id.beatNameView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeatsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.beat_items, parent, false)
        return BeatsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return beats.size
    }

    override fun onBindViewHolder(holder: BeatsViewHolder, position: Int) {
        holder.beatName.text = beats[position].first
        holder.beatName.setOnClickListener {
            val i = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse(beats[position].second)
            }

            try {
                startActivity(holder.itemView.context, i, null)
            } catch (ex: android.content.ActivityNotFoundException) {
                Toast.makeText(holder.itemView.context, "No browser found to open the link.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}