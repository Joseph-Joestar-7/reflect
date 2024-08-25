package com.freshyfive.reflect.ui.recommendations.items

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.freshyfive.reflect.R
import com.freshyfive.reflect.data.Article

class ArticleItemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_items)

        val list = intent.getSerializableExtra("list") as? ArrayList<Article>
        val bookAdapter = list?.let { ArticleAdapter(it) }
        val recyclerView = findViewById<RecyclerView>(R.id.ArticleRecyclerView)
        recyclerView.adapter = bookAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}