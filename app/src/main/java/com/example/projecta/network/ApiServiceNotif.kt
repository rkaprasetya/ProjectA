package com.example.projecta.network

import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.Field
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import java.util.HashMap

interface ApiServiceNotif {
    @FormUrlEncoded
    @POST("notif")
    fun sendNotifRx(@Field ("to")to:String):Observable<ResponseBody>
}