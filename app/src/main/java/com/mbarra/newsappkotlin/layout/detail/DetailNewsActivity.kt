package com.mbarra.newsappkotlin.layout.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.mbarra.newsappkotlin.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_news.*
import org.w3c.dom.Text

class DetailNewsActivity : AppCompatActivity() {

    var judul: String? = ""
    var penulis: String? = ""
    var penjelas: String? = ""
    var tanngal: String? = ""
    var gambar: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_news)

        supportActionBar?.setTitle("Detail News")

        val title = findViewById<TextView>(R.id.txt_news_detail_title)
        val author = findViewById<TextView>(R.id.txt_news_detail_author)
        val desc = findViewById<TextView>(R.id.txt_news_detail_desc)
        val date = findViewById<TextView>(R.id.txt_news_detail_date)
        val imageDetail =findViewById<ImageView>(R.id.img_news_detail)

        judul = intent.getStringExtra("title")
        title.setText(judul)

        penulis = intent.getStringExtra("author")
        author.setText(penulis)

        penjelas = intent.getStringExtra("desc")
        desc.setText(penjelas)

        tanngal = intent.getStringExtra("date")
        date.setText(tanngal)

        gambar = intent.getStringExtra("img")
        if (gambar != null) {
            Picasso.get().load(gambar).into(imageDetail)
        }
    }
}