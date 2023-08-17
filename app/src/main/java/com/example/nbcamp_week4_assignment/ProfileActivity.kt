package com.example.nbcamp_week4_assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.ListView
import com.example.nbcamp_week4_assignment.Adaptor.PostAdaptor
import com.example.nbcamp_week4_assignment.DataClass.Post

class ProfileActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        val img_profile = findViewById<ImageView>(R.id.iv_profile)
        val btnEdit = findViewById<Button>(R.id.btn_edit_profile)

        img_profile.setImageResource(R.drawable.ms)//임시로

        img_profile.clipToOutline = true


        btnEdit.setOnClickListener {
            val intenttoEditProfile = Intent(this, EditProfileActivity::class.java)
            startActivity(intenttoEditProfile)
        }


//        val postListView = findViewById<ListView>(R.id.lv_post)
//        val postAdaptor = PostAdaptor(this, postList)
//        postListView.adapter = postAdaptor


    }
}
