package com.eko8757.customdata.model.data

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResultData (

    @SerializedName("id")
    @Expose
    val id: Long? = null,

    @SerializedName("title")
    @Expose
    val title: String? = null,

    @SerializedName("backdrop_path")
    @Expose
    val backdropPath: String? = null,

    @SerializedName("overview")
    @Expose
    val overview: String? = null
) : Parcelable