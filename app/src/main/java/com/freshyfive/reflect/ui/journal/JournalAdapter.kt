package com.freshyfive.reflect.ui.journal

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.freshyfive.reflect.R
import com.freshyfive.reflect.database.JournalEntity

class JournalAdapter(private val journals: MutableList<JournalEntity>) : RecyclerView.Adapter<JournalAdapter.JournalViewHolder>() {
    inner class JournalViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val journalTitle: TextView = v.findViewById(R.id.journalTitle)
        val journalDate: TextView = v.findViewById(R.id.journalCreatedDate)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JournalViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.grid_item_layout, parent, false)
        return JournalViewHolder(view)
    }

    override fun getItemCount(): Int {
        return journals.size
    }

    override fun onBindViewHolder(holder: JournalViewHolder, position: Int) {
        holder.journalTitle.text = journals[position].title
        holder.journalDate.text = journals[position].createdAt.toString()
        holder.itemView.setOnClickListener {
            val i = Intent(holder.itemView.context, ExpandedJournalActivity::class.java)
            i.putExtra("journalHeader", journals[position].title)
            i.putExtra("journalBody", journals[position].mainText)
            i.putExtra("journalDate", journals[position].createdAt.toString())
            startActivity(holder.itemView.context, i, null)
        }
    }

    fun updateData(newData: List<JournalEntity>) {
        journals.clear()
        journals.addAll(newData)
        notifyDataSetChanged()
    }
}

