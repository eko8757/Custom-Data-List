package com.eko8757.customdata.view.main

import com.eko8757.customdata.model.data.ResultData

interface DataView {

    fun showDataList(data: ArrayList<ResultData>) {

    }

    interface presenter {

        fun getList() {

        }
    }
}