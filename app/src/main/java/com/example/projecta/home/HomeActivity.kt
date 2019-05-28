package com.example.projecta.home

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.projecta.R
import com.example.projecta.circle.CircleActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), HomeContracts.view, View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initButtons()
    }

    override fun onClick(v: View?) {

        when(v!!.id){
            R.id.btn_circle ->  openCircleActivity()
            R.id.btn_help ->{}
            R.id.btn_logout -> {}
            R.id.btn_profile ->{openProfileActivity()}
        }
    }
    private fun initButtons(){

        btn_circle.setOnClickListener(this)
        btn_help.setOnClickListener(this)
        btn_profile.setOnClickListener(this)
    }
    private fun openProfileActivity() {

    }

    private fun openCircleActivity(){
        val intent = Intent(this, CircleActivity::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
    }

    private fun sendHelp(){

    }

    private fun logOut(){

    }


}
