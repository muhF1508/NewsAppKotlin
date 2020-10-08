package com.mbarra.newsappkotlin.layout.main

import com.mbarra.newsappkotlin.model.Article

interface MainConstract {

    interface View {

        fun onFailed(message: String)

        fun showDataNews(dataItemNews: List<Article>)

    }

    interface Presenter {

        fun getDataNews()

    }

}