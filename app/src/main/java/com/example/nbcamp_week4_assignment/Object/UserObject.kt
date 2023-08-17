package com.example.nbcamp_week4_assignment.Object

import com.example.nbcamp_week4_assignment.DataClass.User

object UserObject {
    var users = arrayListOf(
        User("@softychoo", "추민수", "000000","ms"),
        User("@jh4016", "이진혁", "111111","jh"),
        User("@daeulzzang", "이다을", "222222","de"),
        User("@hyyyjunk", "김현준", "333333","hj"),
        User("@yhyang", "양윤혁", "444444","yh")
    )

    fun adduser(id: String, name: String, pw: String, img:String )
    {
        val newUser = User(id = id, name = name, pw = pw, img = img)
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

}