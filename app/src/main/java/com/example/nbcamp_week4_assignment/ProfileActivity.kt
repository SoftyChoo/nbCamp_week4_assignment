package com.example.nbcamp_week4_assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.ListView
import com.example.nbcamp_week4_assignment.Adaptor.PostAdaptor
import com.example.nbcamp_week4_assignment.DataClass.Post

class ProfileActivity : AppCompatActivity() {

//    var postList = arrayListOf<Post>(
//        Post("ms","post_ms1","ms","동명동 나들이 ~"),
//        Post("ms","post_ms2","ms","오랜만에 일본여행!"),
//        Post("yh","post_yh1","yh","행복했던 도쿄여행"),
//        Post("yh","post_yh2","yh","떨렸던 머리 올리기..")
//    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        val img_profile = findViewById<ImageView>(R.id.iv_profile)

        img_profile.setImageResource(R.drawable.ms)//임시로

        img_profile.clipToOutline = true


//        val postListView = findViewById<ListView>(R.id.lv_post)
//        val postAdaptor = PostAdaptor(this, postList)
//        postListView.adapter = postAdaptor



    }
}
