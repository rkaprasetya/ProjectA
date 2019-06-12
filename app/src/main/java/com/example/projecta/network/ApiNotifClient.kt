package com.example.projecta.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiNotifClient {
    val apiNotifClient : ApiServiceNotif
    private val okHttpClient = OkHttpClient.Builder()
        .readTimeout(15,TimeUnit.SECONDS)
        .connectTimeout(15, TimeUnit.SECONDS)
        .build()
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()

        apiNotifClient = retrofit.create(ApiServiceNotif::class.java)
    }

    companion object{
        private const val BASE_URL = "https://fcm.googleapis.com/fcm/send/"
    }

}