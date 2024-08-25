package com.freshyfive.reflect.ui.recommendations.items

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.freshyfive.reflect.R

class ShortfilmItemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_shortfilm_items)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

        val list = intent.getStringArrayListExtra("list")
        val shortFilmAdapter = list?.let { ShortFilmAdapter(it) }
        val recyclerView = findViewById<RecyclerView>(R.id.ShortfilmsRecyclerView)
        recyclerView.adapter = shortFilmAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}