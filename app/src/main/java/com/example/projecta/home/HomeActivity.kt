package com.example.projecta.home

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.projecta.R
import com.example.projecta.circle.CircleActivity
import com.example.projecta.map.MapsActivity
import com.example.projecta.profile.ProfileActivity
import com.example.projecta.settings.SettingsActivity
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), HomeContracts.view, View.OnClickListener {

    override lateinit var dialog: AlertDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        initButtons()
    }

    override fun onClick(v: View?) {

        when (v!!.id) {
            R.id.btn_circle -> openCircleActivity()
            R.id.btn_help -> sendHelp()
            R.id.btn_settings -> openSettingsActivity()
            R.id.tv_logout_no -> dialog.dismiss()
            R.id.tv_logout_yes -> dialog.dismiss()
            R.id.btn_profile -> openProfileActivity()
        }
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

    private fun sendHelp() {
        val intent = Intent(this, MapsActivity::class.java)
        startActivity(intent)
    }

    override fun openSettingsActivity() {
        val intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)

    }


}
