package com.example.waifuku

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

@Suppress("DEPRECATION")
class SplashScreenActivity : AppCompatActivity() {
    private val splashDelay = 1000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        Handler().postDelayed({
            val moveToMain = Intent(this@SplashScreenActivity, MainActivity::class.java)
            startActivity(moveToMain)
            finish()
        }, splashDelay.toLong())
    }
}