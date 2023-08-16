package com.example.nbcamp_week4_assignment.Adaptor

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nbcamp_week4_assignment.DataClass.Post
import com.example.nbcamp_week4_assignment.R
class ProfileAdaptor(val context: Context, private val postList: ArrayList<Post>) :
    RecyclerView.Adapter<ProfileAdaptor.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView
        val imageButton : ImageButton

        init {
            // Define click listener for the ViewHolder's View.
            textView = view.findViewById(R.id.tv_rv)
            imageButton = view.findViewById(R.id.ib_rv)
            imageButton.clipToOutline = true
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.profile_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        val post = postList[position]
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.textView.text = post.user

        val resourceId = context.resources.getIdentifier(post.profile, "drawable", context.packageName)
        viewHolder.imageButton.setImageResource(resourceId)

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = postList.size

}


