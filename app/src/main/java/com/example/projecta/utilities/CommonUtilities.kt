package com.example.projecta.utilities

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager

class CommonUtilities {

    fun isNetworkConnected(activity : Activity):Boolean{
        val connectivityManager = activity.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return  networkInfo!=null && networkInfo.isConnected

    }
}