package com.eko8757.customdata.model.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ResponseData(

    @SerializedName("page")
    @Expose
    val page: Int?,

    @SerializedName("total_results")
    @Expose
    val totalResults: Int?,

    @SerializedName("total_pages")
    @Expose
    val totalPages: Int?,

    @SerializedName("results")
    @Expose
    val results: List<ResultData>?
)