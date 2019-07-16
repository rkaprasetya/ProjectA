package com.example.projecta.home

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.projecta.R
import com.example.projecta.circle.CircleActivity
import com.example.projecta.map.MapsActivity
import com.example.projecta.profile.ProfileActivity
import com.example.projecta.settings.SettingsActivity
import com.example.projecta.utilities.CommonUtilities
import com.google.firebase.FirebaseApp
import com.google.firebase.iid.FirebaseInstanceId
import kotlinx.android.synthetic.main.activity_home.*
import java.io.IOException

class HomeActivity : AppCompatActivity(), HomeContracts.view, View.OnClickListener {


    private var presenter : HomePresenterImpl = HomePresenterImpl(this)
    lateinit var dialog: AlertDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initButtons()
        FirebaseApp.initializeApp(this)

    }

    override fun onClick(v: View?) {

        when (v!!.id) {
            R.id.btn_circle -> openCircleActivity()
            R.id.btn_help -> presenter.sendNotif()
            R.id.btn_settings -> openSettingsActivity()
            R.id.tv_logout_no -> dialog.dismiss()
            R.id.tv_logout_yes -> dialog.dismiss()
            R.id.btn_profile -> openProfileActivity()
        }
    }
    private fun checkInternetConnection(){
        val result = CommonUtilities().isNetworkConnected(this)

    }

    private fun initButtons() {
        btn_settings.setOnClickListener(this)
        btn_circle.setOnClickListener(this)
        btn_help.setOnClickListener(this)
        btn_profile.setOnClickListener(this)
    }

    private fun openProfileActivity() {
        val intent = Intent(this, ProfileActivity::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
    }

    private fun openCircleActivity() {
        val intent = Intent(this, CircleActivity::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
    }
    override fun startNotifThread(){
        FirebaseApp.initializeApp(this)
        Thread(Runnable {
            try {

                Log.i(TAG, FirebaseInstanceId.getInstance().getToken(getString(R.string.sender_id),"FCM"))
            }catch (e: IOException){
                e.printStackTrace()
            }
        }).start()
        sendHelp()
    }

    private fun sendHelp() {
        val intent = Intent(this, MapsActivity::class.java)
        startActivity(intent)
    }

    fun openSettingsActivity() {
        val intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)

    }

    override fun openMapActivity() {
        val intent = Intent(this, MapsActivity::class.java)
        startActivity(intent)

    }

    companion object{
        private const val TAG = "FirebaseToken"
    }


}
