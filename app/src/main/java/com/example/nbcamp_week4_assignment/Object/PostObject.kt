package com.example.nbcamp_week4_assignment.Object

import com.example.nbcamp_week4_assignment.DataClass.Post

object PostObject {
    var postList = arrayListOf<Post>(
        Post("@softyhoo", "추민수", "post_ms1", "ms", "동명동 나들이 ☕️"),
        Post("@yhyang", "양윤혁", "post_yh1", "yh", "행복했던 도쿄여행"),
        Post("@daeulzzang", "이다을", "post_de1", "de", "칠리치즈맛만 3번 먹은날 ㅋㅋㅋ"),
        Post("@jh4016", "이진혁", "post_jh1", "jh", "댕댕이 숙면"),
        Post("@hyyyjunk", "김현준", "post_hj1", "hj", "맥주 한잔~"),

        Post("@softychoo", "추민수", "post_ms2", "ms", "오랜만에 일본여행!\uD83D\uDEE9️"),
        Post("@yhyang", "양윤혁", "post_yh2", "yh", "떨렸던 머리 올리기.."),
        Post("@daeulzzang", "이다을", "post_de2", "de", "왜 다들 여기다가 보관하시는 거에요? \uD83D\uDE2E"),
        Post("@jh4016", "이진혁", "post_jh2", "jh", "사촌 조카\uD83D\uDE42"),
        Post("@hyyyjunk", "김현준", "post_hj2", "hj", "횡령산에서"),
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

    fun personalImg(userName: String?): Post? {
        for (post in postList) {
            if (userName == post.user) {
                return post
            } else {
                continue
            }
        }
        return null
    }
    fun personalPost(userName: String?, personalList: ArrayList<Post>): ArrayList<Post> {
        for (post in postList) {
            if (userName == post.user) {
                personalList.add(post)
            } else {
                continue
            }
        }
        return personalList
    }

//    fun get
}