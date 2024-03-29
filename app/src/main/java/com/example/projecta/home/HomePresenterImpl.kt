package com.example.projecta.home

import android.util.Log
import com.example.projecta.firebase.authentication.FirebaseAuthenticationManager
import com.example.projecta.firebase.database.FirebaseDatabaseManager
import com.example.projecta.network.ApiNotifClient
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody

class HomePresenterImpl(var view:HomeContracts.view): HomeContracts.presenter {
    private val db : FirebaseDatabaseManager = FirebaseDatabaseManager()
    private val authentication: FirebaseAuthenticationManager = FirebaseAuthenticationManager()
    lateinit var disposable: Disposable
    override fun sendNotif() {
        view.openMapActivity()
       //startNotifApi(getParams())
    }
    private fun startNotifApi(map: HashMap<String,String>){

        val call = ApiNotifClient().apiNotifClient.sendNotifRx(token)
        call.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<ResponseBody>{
                override fun onComplete() {
                    Log.e("complete","complete")
                }

                override fun onSubscribe(d: Disposable) {
                    disposable = d
                }

                override fun onNext(t: ResponseBody) {
                    val response = t.string()
                    Log.e(TAG,"OnResponse: Notification ->$response")
                }

                override fun onError(e: Throwable) {
                    Log.e("", "Error found: ${e.message}")
                }

            })
    }

    private fun getParams(): java.util.HashMap<String, String> {
        val map = HashMap<String,String>()
        val data = HashMap<String,String>()
        map.put("to",token)
        return map
    }


    override fun getCircle() {
        val id = authentication.getUserId()
        db.getCircle(id){
                user ->
            if(user == null){

            }else{

            }
        }
    }

    companion object{
        private const val TAG = "NOTIF RESPONSE"
        private const val token = "fJg2a26MOHA:APA91bF0aWbfOk6BJQmJzhIT6DgiQJHE0Dypy1hsml7dawvf9Om4rJAcwZAgYMWs9A8_MULSO1jNzs53NLSqW2bqXdxau0VyC6Qav1VgDtkIhM5pYjeP7x3U6tTvTI0nHcowwc2li2rs"
    }
}