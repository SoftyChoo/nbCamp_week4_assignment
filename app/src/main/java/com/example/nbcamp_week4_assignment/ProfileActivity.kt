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
        val profileId = findViewById<TextView>(R.id.tv_profile_id)

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


        //recyclerView를 클릭했을 때 받아온 유저의 이름
        var rv_userName = intent.getStringExtra("rv_userName")
        //받아온 유저의 이름대로 바꿔줌
        profileName.setText(rv_userName)

        //개인 postList 생성
        var personalList = arrayListOf<Post>()

        //Object에 개인List를 보내 받아온 유저의 이름과 같은 포스트 리스트만 받아옴
        personalList = PostObject.personalPost(profileName.text.toString(),personalList)
        val personalPost = findViewById<ListView>(R.id.lv_post)

        val postAdaptor = PostAdaptor(this, personalList)
        personalPost.adapter = postAdaptor

        //porfile을 받아온 유저에 맞게 수정
        var changeProfile = PostObject.personalImg(profileName.text.toString())

        val resourceId = this.resources.getIdentifier(changeProfile?.profile, "drawable", this.packageName)
        img_profile.setImageResource(resourceId)

        profileId.setText(changeProfile?.id)



        btnEdit.setOnClickListener {
            val intenttoEditProfile = Intent(this, EditProfileActivity::class.java)
            startActivity(intenttoEditProfile)
        }

    }
}
