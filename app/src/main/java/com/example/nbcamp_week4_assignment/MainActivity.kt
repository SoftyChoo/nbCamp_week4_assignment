package com.example.nbcamp_week4_assignment

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nbcamp_week4_assignment.Adaptor.PostAdaptor
import com.example.nbcamp_week4_assignment.Adaptor.ProfileAdaptor
import com.example.nbcamp_week4_assignment.DataClass.Post
import com.example.nbcamp_week4_assignment.Object.PostObject


class MainActivity : AppCompatActivity() {
    //로그인 한 User의 Id값을 가지고있기


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userId = intent.getStringExtra("userId")


        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)



        //Object에서 리스트를 받아옴
        val postList = PostObject.readPost()

        //메인화면에 나타나는 모든 Post를 ListView로 나타냄
        val postListView = findViewById<ListView>(R.id.lv_post_main)
        val postAdaptor = PostAdaptor(this, postList)
        postListView.adapter = postAdaptor

        //메인화면의 User목록을 InstagramStory 처럼 가로로 나타냄(Recyclerview)
        val postRecyclerView = findViewById<RecyclerView>(R.id.rv_profile_main)

        //RecyclerView 가로로 변환해주는 코드
        postRecyclerView.layoutManager =LinearLayoutManager(this).also { it.orientation = LinearLayoutManager.HORIZONTAL }
        val adapter = ProfileAdaptor(this, postList)
        postRecyclerView.setAdapter(adapter)



        supportActionBar!!.setDisplayShowTitleEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

    }
//    fun getUserId(): String? {
//        return userId
//    }

}