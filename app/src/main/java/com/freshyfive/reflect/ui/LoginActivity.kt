package com.freshyfive.reflect.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.freshyfive.reflect.R
import com.freshyfive.reflect.models.saveUserData

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val username = findViewById<EditText>(R.id.username)
        val whatDefinesYou = findViewById<Spinner>(R.id.WhatDefinesYou)
        val gender = findViewById<Spinner>(R.id.Gender)
        val getStarted = findViewById<Button>(R.id.GetStarted)

        getStarted.setOnClickListener {
            val usernameText = username.text.toString()
            val whatDefinesYouText = whatDefinesYou.selectedItem.toString()
            val genderText = gender.selectedItem.toString()

            saveUserData(this, usernameText, genderText, whatDefinesYouText)
            val i = Intent(this, FeelingActivity::class.java)
            startActivity(i)
            finish()
        }
    }
}