package com.freshyfive.reflect.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.freshyfive.reflect.R
import com.freshyfive.reflect.models.saveMood

class FeelingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_feeling)
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
//            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
//            insets
//        }

//        val openHomeBtn = findViewById<Button>(R.id.openHome)
//        openHomeBtn.setOnClickListener {
//            val i = Intent(this, HomeActivity::class.java)
//            startActivity(i)
//            finish()
//        }

    }

    fun setMood(view: View) {
        val viewId = view.id
        when(viewId) {
            R.id.Sad -> {
                saveMood(this, "Sad")
            }
            R.id.Angry -> {
                saveMood(this, "Angry")
            }
            R.id.Depressed -> {
                saveMood(this, "Depressed")
            }
            R.id.Worried -> {
                saveMood(this, "Worried")
            }
            R.id.Frustrated -> {
                saveMood(this, "Frustrated")
            }
            R.id.Anxious -> {
                saveMood(this, "Anxious")
            }
        }
        val i = Intent(this, HomeActivity::class.java)
        startActivity(i)
        finish()
    }
}