package com.example.nbcamp_week4_assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        var img_profile = findViewById<ImageView>(R.id.iv_profile)

        img_profile.setImageResource(R.drawable.ms)
        img_profile.clipToOutline = true


    }
}