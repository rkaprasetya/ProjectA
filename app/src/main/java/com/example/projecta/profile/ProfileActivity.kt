package com.example.projecta.profile

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.projecta.R
import com.example.projecta.circle.CircleActivity
import com.example.projecta.home.HomeActivity
import com.example.projecta.settings.SettingsActivity
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.dialog_logout.view.*

class ProfileActivity : AppCompatActivity(), View.OnClickListener,
    ProfileContracts.view {

    override lateinit var dialog: AlertDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        initButtons()
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btn_profile_home -> openHomeActivity()
            R.id.btn_profile_change -> {
            }
            R.id.btn_profile_circle -> openCircleActivity()
            R.id.btn_profile_settings -> openSettingsActivity()
            R.id.tv_logout_no -> dialog.dismiss()
            R.id.tv_logout_yes -> dialog.dismiss()
        }
    }

    override fun openSettingsActivity() {
        val intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
    }


    private fun openCircleActivity() {
        val intent = Intent(this, CircleActivity::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }

    private fun initButtons() {
        btn_profile_change.setOnClickListener(this)
        btn_profile_home.setOnClickListener(this)
        btn_profile_settings.setOnClickListener(this)
        btn_profile_circle.setOnClickListener(this)
    }

    private fun openHomeActivity() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }
}
