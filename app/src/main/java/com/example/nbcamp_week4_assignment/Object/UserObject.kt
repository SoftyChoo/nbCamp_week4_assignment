package com.example.nbcamp_week4_assignment.Object

import android.net.Uri
import com.example.nbcamp_week4_assignment.DataClass.Post
import com.example.nbcamp_week4_assignment.DataClass.User
import com.example.nbcamp_week4_assignment.R

object UserObject {
    var users = arrayListOf(
        User("@softychoo", "추민수", "000000", R.drawable.ms.toString()),
        User("@jh4016", "이진혁", "111111",R.drawable.jh.toString()),
        User("@daeulzzang", "이다을", "222222",R.drawable.de.toString()),
        User("@hyyyjunk", "김현준", "333333",R.drawable.hj.toString()),
        User("@yhyang", "양윤혁", "444444",R.drawable.yh.toString())
    )

    fun adduser(id: String, name: String, pw: String, img: String)
    {
        val newUser = User(id = id, name = name, pw = pw, imageUri = img)
        users.add(newUser)
    }


    fun readusers(userName: String, userPW: String): User? {
        for (user in users) {
            if (userName == user.id && userPW ==user.pw) {
                return user
            } else {
                continue
            }
        }
        return null
    }

    fun readUserName(userName: String?) :User?{
        for (user in users) {
            if (userName == user.name) {
                return user
            } else {
                continue
            }
        }
        return null
    }

    fun readUser(): ArrayList<User> {
        return users
    }

    fun editProfile(imageUri: String, name: String, id: String,compareName:String) {
        for (user in users) {
            if (user.name == compareName) {
                user.imageUri = "test"
                user.name = name
                user.id = id
                break
            }
        }
    }
    //로그인값을 받아와서 가지고있다가 개인프로필에서 사용
    var signInUser : String = ""
    fun addSignInUser(userId : String){
        for(user in users)
        {
            if(user.id == userId)
            {
                signInUser = user.name
            }
        }
    }
    fun personalImg(userName: String?): User? {
        for (user in users) {
            if (userName == user.name) {
                return user
            } else {
                continue
            }
        }
        return null
    }
}