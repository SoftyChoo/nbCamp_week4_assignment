package com.example.nbcamp_week4_assignment.Object

import com.example.nbcamp_week4_assignment.DataClass.Post
import com.example.nbcamp_week4_assignment.DataClass.User

object UserObject {
    var users = arrayListOf(
        User("softychoo", "추민수", "000000"),
        User("user1", "이진혁", "111111"),
        User("user2", "이다을", "222222"),
        User("user3", "김현준", "333333"),
        User("user4", "양윤혁", "444444")
    )

    fun addPost(id: String, name: String, pw: String, )
    {
        val newUser = User(id = id, name = name, pw = pw)
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

    fun readUser(): ArrayList<User> {
        return users
    }
}