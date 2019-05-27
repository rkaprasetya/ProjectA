package com.example.projecta.Home

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.projecta.R

class HomeActivity : AppCompatActivity(), HomeContracts.view, View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btn_circle -> {}
            R.id.btn_help ->{}
            R.id.btn_logout -> {}
            R.id.btn_profile ->{openProfileActivity()}
        }
    }

    private fun openProfileActivity() {

    }

    private fun openCircleActivity(){

    }

    private fun sendHelp(){

    }

    private fun logOut(){

    }


}
