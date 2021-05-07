package com.example.mvvmdemo.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmdemo.Model.Post
import com.example.mvvmdemo.R
import kotlinx.android.synthetic.main.each_row.view.*

class PostAdapter (private val context: Context,private  var postList: ArrayList<Post>):RecyclerView.Adapter<PostAdapter.PostViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.each_row,parent,false))

    }

    override fun getItemCount(): Int =postList.size

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {

        val post=postList[position]
        holder.id.text=post.id.toString()
        holder.title.text=post.title



    }
    class PostViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)
    {
        val id=itemView.findViewById<TextView>(R.id.id)//----->1
        val title:TextView=itemView.findViewById(R.id.title)

    }

    fun setData( postList: ArrayList<Post>)
    {
        this.postList=postList
        notifyDataSetChanged()
    }
}