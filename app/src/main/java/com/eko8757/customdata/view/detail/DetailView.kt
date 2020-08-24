package com.eko8757.customdata.view.detail

import android.content.Context
import com.eko8757.customdata.model.data.ResultData

interface DetailView {

    fun getData() {

    }

    fun showData(
        image: String,
        title: String,
        desc: String
    ) {

    }

    interface presenter {
        fun extractData(context: Context, data: ResultData)
    }
}