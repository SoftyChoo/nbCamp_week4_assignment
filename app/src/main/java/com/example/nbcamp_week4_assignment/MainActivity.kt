package com.example.nbcamp_week4_assignment

import android.content.Intent
import android.os.Bundle
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

//    var postList = arrayListOf<Post>(
//        Post("softyhoo","추민수", "post_ms1", "ms", "동명동 나들이 ~"),
//        Post("yh","양윤혁", "post_yh1", "yh", "행복했던 도쿄여행"),
//        Post("de","이다을", "post_de1", "de", "칠리치즈맛만 3번 먹은날 ㅋㅋㅋ"),
//
//
//        Post("softychoo","추민수", "post_ms2", "ms", "오랜만에 일본여행!"),
//        Post("yh","양윤혁", "post_yh2", "yh", "떨렸던 머리 올리기.."),
//        Post("de","이다을", "post_de2", "de", "왜 다들 여기다가 보관하시는 거에요? \uD83D\uDE2E"),
//
//    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


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



        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowTitleEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)


//        postListView.setOnClickListener {
//            //Toast.makeText(this, "${postListView}", Toast.LENGTH_SHORT).show()
//            val intentToProfilePage = Intent(this,ProfileActivity::class.java)
//            startActivity(intentToProfilePage)
//        }
    }
}