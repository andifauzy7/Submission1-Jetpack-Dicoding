package com.example.moviecatalogue.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.moviecatalogue.R
import com.example.moviecatalogue.ui.main.MainActivity


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler(Looper.getMainLooper()).postDelayed({
            val i = Intent(applicationContext, MainActivity::class.java)
            startActivity(i)
            finish()
        }, 3000)
    }
}