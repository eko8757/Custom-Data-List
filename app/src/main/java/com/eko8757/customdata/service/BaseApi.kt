package com.eko8757.customdata.service

import com.eko8757.customdata.model.data.ResponseData
import com.google.gson.GsonBuilder
import io.reactivex.Observable
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

interface BaseApi {

    @GET("discover/movie?")
    fun getDataList(
        @Query("api_key") api_key: String,
        @Query("language") language: String
    ) : Observable<Response<ResponseData>>

    companion object {
        val URL: String = com.eko8757.customdata.utils.Constants.BASE_URL
        fun create(): BaseApi {
            val gson = GsonBuilder()
                .setLenient()
                .create()

            val clientBuilder = OkHttpClient.Builder()
            clientBuilder.connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .build()

            val client = clientBuilder.build()
            val retrofit = Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

            return retrofit.create(BaseApi::class.java)
        }
    }
}