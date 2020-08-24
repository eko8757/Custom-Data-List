package com.eko8757.customdata.presenter.data

import android.content.Context
import com.eko8757.customdata.model.data.ResultData
import com.eko8757.customdata.view.detail.DetailView

class PresenterDetail(val view: DetailView) : DetailView.presenter {

    private lateinit var dataGlobal: ResultData
    private var id: Long = 0

    override fun extractData(context: Context, data: ResultData) {
        val image = data.backdropPath.toString()
        val title = data.title.toString()
        val desc = data.overview.toString()
        view.showData(image, title, desc)
        this.dataGlobal = data
        this.id = data.id!!
    }
}