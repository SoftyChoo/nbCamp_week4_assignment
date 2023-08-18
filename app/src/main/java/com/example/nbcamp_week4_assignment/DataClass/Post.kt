package com.example.nbcamp_week4_assignment.DataClass

import android.graphics.drawable.Drawable

data class Post(
    var id: String,
    var user: String,
    val img: String,
    var profile: String,
    val content: String
) {
}