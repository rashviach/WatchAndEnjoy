package com.example.watchandenjoy

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RecyclerAdapter(
    private val context: Context,
    private val imageURLList: ArrayList<String>
) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_recycler, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        // 1
        val pos = if (position >= imageURLList.size) position % imageURLList.size else position
        val imageUrl = imageURLList[pos]
        val iv = viewHolder.itemView.findViewById<ImageView>(R.id.iv)
        Glide.with(context)
            .load(imageUrl)
            .placeholder(R.mipmap.autorenew)
            .skipMemoryCache(true)
            .into(iv)
        TODO("if no internet then show toast on 1")
    }

    override fun getItemCount(): Int {
        return imageURLList.size * 3
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}