package com.mbarra.newsappkotlin.layout.main

import com.mbarra.newsappkotlin.model.Article
import com.mbarra.newsappkotlin.model.NewsModel
import com.mbarra.newsappkotlin.network.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Suppress("UNCHECKED_CAST")
class MainPresenter(model: MainConstract.View): MainConstract.Presenter {

    var view: MainConstract.View? = null

    init {
        view = model
    }

    override fun getDataNews() {
        ApiConfig.create().getNews().enqueue(object : Callback<NewsModel> {
            override fun onResponse(call: Call<NewsModel>, response: Response<NewsModel>) {
                if (response.isSuccessful) {
                    view?.showDataNews(response.body()?.articles as List<Article>)
                } else {
                    view?.onFailed(response.toString())
                }
            }

            override fun onFailure(call: Call<NewsModel>, t: Throwable) {
                view?.onFailed(t.toString())
            }

        })
    }

}