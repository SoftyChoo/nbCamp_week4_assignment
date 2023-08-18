package com.example.nbcamp_week4_assignment

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import com.example.nbcamp_week4_assignment.Adaptor.PostAdaptor
import com.example.nbcamp_week4_assignment.DataClass.Post
import com.example.nbcamp_week4_assignment.Object.PostObject
import com.example.nbcamp_week4_assignment.Object.UserObject


class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        val img_profile = findViewById<ImageView>(R.id.iv_profile)
        val btnEdit = findViewById<Button>(R.id.btn_edit_profile)
        val profileName = findViewById<TextView>(R.id.tv_profile_name)
        val profileId = findViewById<TextView>(R.id.tv_profile_id)
        val main_btn = findViewById<Button>(R.id.main_btn)

        img_profile.clipToOutline = true

        //recyclerView를 클릭했을 때 받아온 유저의 이름
        var rv_userName = intent.getStringExtra("rv_name").toString()

        //SignIn한 유저의 프로필에서만 EditProfile버튼이 활성화되도록 설정
        if(rv_userName == UserObject.signInUser){
            btnEdit.visibility = View.VISIBLE
        }
        else
        {
            btnEdit.visibility = View.GONE
        }

        //개인 postList 생성
        var personalList = arrayListOf<Post>()



        if( null !=UserObject.readUserName(rv_userName))
        {
            //post가 있을때만 받아옴
            if(PostObject.checkPost(rv_userName) == true){
                //Object에 개인List를 보내 받아온 유저의 이름과 같은 포스트 리스트만 받아옴
                personalList = PostObject.personalPost(rv_userName,personalList)
                val personalPost = findViewById<ListView>(R.id.lv_post)

                val postAdaptor = PostAdaptor(this, personalList)
                personalPost.adapter = postAdaptor
            }
            else
            {
                val postState = findViewById<TextView>(R.id.tv_postState)
                postState.setText("No Post")
            }
            //받아온 유저의 이름대로 바꿔줌
            profileName.setText(rv_userName)

            //profile을 받아온 유저에 맞게 수정
            var changeProfile = UserObject.personalImg(profileName.text.toString())

            val resourceId = this.resources.getIdentifier(changeProfile?.imageUri.toString(), "drawable", this.packageName)
            img_profile.setImageResource(resourceId)

            profileId.setText(changeProfile?.id)
        }
        else{
            // 수정된 정보 화면 표시
            val imageUri = intent.getParcelableExtra<Uri>("imageUri")
            val inputName = intent.getStringExtra("name")
            val inputId = intent.getStringExtra("id")
            img_profile.setImageURI(imageUri)
            profileName.text = inputName
            profileId.text = inputId
            if(PostObject.checkPost(inputName.toString()) == true){
                personalList = PostObject.personalPost(inputName.toString(),personalList)
                val personalPost = findViewById<ListView>(R.id.lv_post)

                val postAdaptor = PostAdaptor(this, personalList)
                personalPost.adapter = postAdaptor
            }
            else {
                val postState = findViewById<TextView>(R.id.tv_postState)
                postState.setText("No Post")
            }
        }


        btnEdit.setOnClickListener {
            val intenttoEditProfile = Intent(this, EditProfileActivity::class.java)
            intenttoEditProfile.putExtra("rv_name",rv_userName)
            startActivity(intenttoEditProfile)
            overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right)
            finish()
        }
        main_btn.setOnClickListener {
            val intenttoEditProfile = Intent(this, MainActivity::class.java)
            startActivity(intenttoEditProfile)
            overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right)
            finish()
        }
    }
}