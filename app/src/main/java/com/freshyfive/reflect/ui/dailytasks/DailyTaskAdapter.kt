package com.freshyfive.reflect.ui.dailytasks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.freshyfive.reflect.R
import com.freshyfive.reflect.database.JournalEntity
import com.freshyfive.reflect.database.TaskEntity

class DailyTaskAdapter(private val dailytasks: List<TaskEntity>) : RecyclerView.Adapter<DailyTaskAdapter.TaskViewHolder>() {
    inner class TaskViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val taskName: TextView = v.findViewById(R.id.taskName)
        val isCompleted: TextView = v.findViewById(R.id.isCompleted)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.task_item_layout, parent, false)
        return TaskViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dailytasks.size
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.taskName.text = dailytasks[position].taskName
        holder.isCompleted.text = dailytasks[position].isCompleted.toString()
    }
}