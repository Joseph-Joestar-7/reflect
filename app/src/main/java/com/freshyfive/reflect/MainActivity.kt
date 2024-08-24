package com.freshyfive.reflect

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.freshyfive.reflect.models.isMoodAvailable
import com.freshyfive.reflect.models.isUserDataAvailable
import com.freshyfive.reflect.ui.FeelingActivity
import com.freshyfive.reflect.ui.HomeActivity
import com.freshyfive.reflect.ui.LoginActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (isUserDataAvailable(this)) {
            if (isMoodAvailable(this)) {
                val i = Intent(this, HomeActivity::class.java)
                startActivity(i)
                finish()
            } else {
                val i = Intent(this, FeelingActivity::class.java)
                startActivity(i)
                finish()
            }
        } else {
            val i = Intent(this, LoginActivity::class.java)
            startActivity(i)
            finish()
        }

    }
}