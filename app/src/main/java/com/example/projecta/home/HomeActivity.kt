package com.example.projecta.home

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.projecta.R
import com.example.projecta.circle.CircleActivity
import com.example.projecta.map.MapsActivity
import com.example.projecta.profile.ProfileActivity
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.dialog_logout.view.*

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
            R.id.btn_logout -> openLogoutDialog()
            R.id.tv_logout_no -> dialog.dismiss()
            R.id.tv_logout_yes -> dialog.dismiss()
            R.id.btn_profile -> openProfileActivity()
        }
    }

    private fun initButtons() {
        btn_logout.setOnClickListener(this)
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

    override fun openLogoutDialog() {
        val builder = AlertDialog.Builder(this)
        val view = layoutInflater.inflate(R.layout.dialog_logout, null)
        builder.setView(view)
        dialog = builder.create()
        dialog.show()
        view.tv_logout_yes.setOnClickListener(this)
        view.tv_logout_no.setOnClickListener(this)
    }


}
