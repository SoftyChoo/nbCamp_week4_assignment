package com.example.nbcamp_week4_assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.nbcamp_week4_assignment.Object.PostObject
import com.example.nbcamp_week4_assignment.Object.UserObject

class AddPostActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_post)

        val btn_save = findViewById<Button>(R.id.btn_savePost)
        val btn_cancel = findViewById<Button>(R.id.btn_cancelPost)
        val contentPost = findViewById<EditText>(R.id.et_content)
        val rv_userName = intent.getStringExtra("rv_userName").toString()


        val addPostUser = PostObject.addPostCheck(rv_userName)

        btn_save.setOnClickListener {
            if(contentPost.text.isEmpty())
            {
                Toast.makeText(this,getString(R.string.information), Toast.LENGTH_SHORT).show()
            }
            else
            {
                if (addPostUser != null) {
                    PostObject.addPost(addPostUser.id, addPostUser.user,"noimg",addPostUser.profile,contentPost.text.toString())
                }
                val intentToProfile = Intent(this,ProfileActivity::class.java)
                intentToProfile.putExtra("rv_name",rv_userName)
                startActivity(intentToProfile)
            }
        }
        btn_cancel.setOnClickListener {
            finish()
        }


    }
}