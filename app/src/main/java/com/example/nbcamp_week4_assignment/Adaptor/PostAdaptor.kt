package com.example.nbcamp_week4_assignment.Adaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.nbcamp_week4_assignment.DataClass.Post
import com.example.nbcamp_week4_assignment.R

class PostAdaptor(val context: Context,var postList: ArrayList<Post>) :BaseAdapter() {
    override fun getCount(): Int {
        return postList.size
    }

    override fun getItem(position: Int): Any {
        return postList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        /* LayoutInflater는 item을 Adapter에서 사용할 View로 부풀려주는(inflate) 역할을 한다. */
        val view: View = LayoutInflater.from(context).inflate(R.layout.post_item, null)

        /* 위에서 생성된 view를 res-layout-main_lv_item.xml 파일의 각 View와 연결하는 과정이다. */
        val iv_post = view.findViewById<ImageView>(R.id.iv_post)
        val iv_post_bg = view.findViewById<ImageView>(R.id.iv_post_bg)
        val tv_post_id = view.findViewById<TextView>(R.id.tv_post_id)
        val tv_post_name = view.findViewById<TextView>(R.id.tv_post_name)
        val tv_post_content = view.findViewById<TextView>(R.id.tv_post_content)

        iv_post.clipToOutline = true
        iv_post_bg.clipToOutline = true

        /* ArrayList<Post>의 변수 Post의 이미지와 데이터를 ImageView와 TextView에 담는다. */
        val post = postList[position]


        val profile_resourceId = context.resources.getIdentifier(post.profile, "drawable", context.packageName)
        val img_resourceId = context.resources.getIdentifier(post.img, "drawable", context.packageName)
        iv_post.setImageResource(profile_resourceId)
        iv_post_bg.setImageResource(img_resourceId)
        tv_post_id.text = "Softychoo"
        tv_post_name.text = "추민수"
        tv_post_content.text = post.content

        return view
    }
}