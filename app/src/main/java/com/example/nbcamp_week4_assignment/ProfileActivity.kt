package com.example.nbcamp_week4_assignment

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import com.example.nbcamp_week4_assignment.Adaptor.PostAdaptor
import com.example.nbcamp_week4_assignment.DataClass.Post
import com.example.nbcamp_week4_assignment.Object.PostObject

class ProfileActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        val img_profile = findViewById<ImageView>(R.id.iv_profile)
        val btnEdit = findViewById<Button>(R.id.btn_edit_profile)
        val profileName = findViewById<TextView>(R.id.tv_profile_name)

        img_profile.setImageResource(R.drawable.ms)//임시로

        img_profile.clipToOutline = true

        // EditProfile 데이터
        val imageUri: Uri? = intent.getParcelableExtra("imageUri")
        imageUri?.let {
            img_profile.setImageURI(it)
        }
        val inputName = intent.getStringExtra("name")
        val nameText = findViewById<TextView>(R.id.tv_profile_name)
        nameText.text = inputName
        val inputId = intent.getStringExtra("id")
        val idText = findViewById<TextView>(R.id.tv_profile_id)
        idText.text = inputId


        btnEdit.setOnClickListener {
            val intenttoEditProfile = Intent(this, EditProfileActivity::class.java)
            startActivity(intenttoEditProfile)
        }
        //Object에서 리스트를 받아옴
        var personalList = arrayListOf<Post>(

        )


        personalList = PostObject.personalPost(profileName.text.toString(),personalList)
        val personalPost = findViewById<ListView>(R.id.lv_post)

        val postAdaptor = PostAdaptor(this, personalList)
        personalPost.adapter = postAdaptor



//        val postListView = findViewById<ListView>(R.id.lv_post)
//        val postAdaptor = PostAdaptor(this, postList)
//        postListView.adapter = postAdaptor


    }
}
