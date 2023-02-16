package com.jean.rockpaperscissorsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.bumptech.glide.Glide
import com.jean.rockpaperscissorsapp.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    companion object {
        val IMAGE_URL = "https://i.ibb.co/HC5ZPgD/splash-screen1.png"
    }

    private val binding: ActivitySplashBinding by lazy {
        ActivitySplashBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.imgSplash2.setImageResource(R.drawable.splash_screen2)

        Glide.with(this)
            .load(IMAGE_URL)
            .centerCrop()
            .into(binding.imgSplash1)

        Handler().postDelayed({
            val intent = Intent(this, LandingActivity::class.java)
            startActivity(intent)
        }, 3000)

    }
}