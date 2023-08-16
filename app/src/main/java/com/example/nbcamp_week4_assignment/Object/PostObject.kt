package com.example.nbcamp_week4_assignment.Object

import com.example.nbcamp_week4_assignment.DataClass.Post

object PostObject {
    var postList = arrayListOf<Post>(
        Post("softyhoo", "추민수", "post_ms1", "ms", "동명동 나들이 ~"),
        Post("yh", "양윤혁", "post_yh1", "yh", "행복했던 도쿄여행"),
        Post("de", "이다을", "post_de1", "de", "칠리치즈맛만 3번 먹은날 ㅋㅋㅋ"),


        Post("softychoo", "추민수", "post_ms2", "ms", "오랜만에 일본여행!"),
        Post("yh", "양윤혁", "post_yh2", "yh", "떨렸던 머리 올리기.."),
        Post("de", "이다을", "post_de2", "de", "왜 다들 여기다가 보관하시는 거에요? \uD83D\uDE2E")
    )

    fun addPost(
        id: String,
        user: String,
        img: String,
        profile: String,
        content: String
    ) {
        val newPost = Post(id = id, user = user, img = img, profile = profile, content = content)
        postList.add(newPost)
    }

    fun readPost(): ArrayList<Post> {
        return postList
    }

//    fun readPost(userName: String): Post? {
//        for (user in postList) {
//            if (userName == user.id) {
//                return user
//            } else {
//                continue
//            }
//        }
//        return null
//    }
}