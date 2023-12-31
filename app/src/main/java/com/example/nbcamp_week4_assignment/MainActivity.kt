package com.example.nbcamp_week4_assignment

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.nbcamp_week4_assignment.Adaptor.PostAdaptor
import com.example.nbcamp_week4_assignment.Adaptor.ProfileAdaptor
import com.example.nbcamp_week4_assignment.Object.PostObject
import com.example.nbcamp_week4_assignment.Object.UserObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        supportActionBar!!.setDisplayShowTitleEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

    }

    override fun onStart() {
        super.onStart()
        //Object에서 리스트를 받아옴
        val postList = PostObject.readPost()

        //메인화면에 나타나는 모든 Post를 ListView로 나타냄
        val postListView = findViewById<ListView>(R.id.lv_post_main)
        val postAdaptor = PostAdaptor(this, postList)
        postListView.adapter = postAdaptor

        val userList = UserObject.readUser()

        //메인화면의 User목록을 InstagramStory 처럼 가로로 나타냄(Recyclerview)
        val postRecyclerView = findViewById<RecyclerView>(R.id.rv_profile_main)

        //RecyclerView 가로로 변환해주는 코드
        postRecyclerView.layoutManager =
            LinearLayoutManager(this).also { it.orientation = LinearLayoutManager.HORIZONTAL }
        val adapter = ProfileAdaptor(this, userList)
        postRecyclerView.setAdapter(adapter)
    }
}