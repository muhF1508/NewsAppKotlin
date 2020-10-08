package com.mbarra.newsappkotlin.layout.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.mbarra.newsappkotlin.R
import com.mbarra.newsappkotlin.adapter.NewsAdapter
import com.mbarra.newsappkotlin.model.Article
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainConstract.View {

    lateinit var presenter: MainPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MainPresenter(this)
        presenter.getDataNews()
    }

    override fun onFailed(message: String) {
        Toast.makeText(this,"Sedang Masalah",Toast.LENGTH_SHORT).show()
    }


    override fun showDataNews(dataItemNews: List<Article>) {
        rv_list_berita.setHasFixedSize(true)
        rv_list_berita.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_list_berita.adapter = NewsAdapter(this, dataItemNews)
    }
}