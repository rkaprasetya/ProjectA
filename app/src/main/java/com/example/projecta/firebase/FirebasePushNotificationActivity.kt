package com.example.projecta.firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.projecta.R
import com.google.firebase.FirebaseApp
import com.google.firebase.iid.FirebaseInstanceId
import java.io.IOException

class FirebasePushNotificationActivity : AppCompatActivity() {
    private val TAG = "FirabaseToken"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firebase_push_notification)
        FirebaseApp.initializeApp(this)
        initView()
    }

    private fun initView() {

        Thread(Runnable {
            try {

                Log.i(TAG, FirebaseInstanceId.getInstance().getToken("UserId","FCM"))
            }catch (e: IOException){
                e.printStackTrace()
            }
        }).start()
    }


}
