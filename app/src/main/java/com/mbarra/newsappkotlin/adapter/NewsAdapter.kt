package com.mbarra.newsappkotlin.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import com.mbarra.newsappkotlin.R
import com.mbarra.newsappkotlin.layout.detail.DetailNewsActivity
import com.mbarra.newsappkotlin.model.Article
import com.squareup.picasso.Picasso

class NewsAdapter(c: Context?, data: List<Article>?) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    var dataItemNews: List<Article>? = data
    var mContext: Context? = c


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.ViewHolder {
        val inflater = LayoutInflater.from(mContext).inflate(R.layout.item_news_list, parent, false)
        return ViewHolder(inflater)
    }

    override fun getItemCount(): Int {
        return dataItemNews?.size!!
    }

    override fun onBindViewHolder(holder: NewsAdapter.ViewHolder, position: Int) {


        holder.content?.text = dataItemNews?.get(position)?.content
        holder.date?.text = dataItemNews?.get(position)?.publishedAt
        Picasso.get().load(dataItemNews?.get(position)?.urlToImage).into(holder.imgContent)

        holder.itemView.setOnClickListener {
            val intent = Intent(mContext, DetailNewsActivity::class.java)
            intent.putExtra("img", dataItemNews?.get(position)?.urlToImage)
            intent.putExtra("title", dataItemNews?.get(position)?.title)
            intent.putExtra("author", dataItemNews?.get(position)?.author)
            intent.putExtra("desc", dataItemNews?.get(position)?.description)
            intent.putExtra("date", dataItemNews?.get(position)?.publishedAt)
            mContext!!.startActivity(intent)
        }

    }

    class ViewHolder(itemView: View?): RecyclerView.ViewHolder(itemView!!) {
        var imgContent = itemView?.findViewById<ImageView>(R.id.img_main)
        var content = itemView?.findViewById<TextView>(R.id.txt_title)
        var date = itemView?.findViewById<TextView>(R.id.txt_date)

    }

}