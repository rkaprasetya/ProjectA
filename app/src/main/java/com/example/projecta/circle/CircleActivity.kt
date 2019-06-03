package com.example.projecta.circle

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.projecta.R
import com.example.projecta.home.HomeActivity
import com.example.projecta.profile.ProfileActivity
import com.example.projecta.settings.SettingsActivity
import kotlinx.android.synthetic.main.activity_circle.*

class CircleActivity : AppCompatActivity(), CircleContracts.view,
    View.OnClickListener {
    override lateinit var dialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_circle)
        initButtons()
    }

    private fun initButtons() {
        btn_circle_home.setOnClickListener(this)
        btn_circle_profile.setOnClickListener(this)
        btn_circle_settings.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btn_circle_home -> openHomeActivity()
            R.id.btn_circle_profile -> openProfileActivity()
            R.id.tv_logout_yes -> dialog.dismiss()
            R.id.tv_logout_no -> dialog.dismiss()
            R.id.btn_circle_settings -> openSettingsActivity()
        }
    }

    private fun openProfileActivity() {
        val intent = Intent(this, ProfileActivity::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
    }

    private fun openHomeActivity() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }

    override fun openSettingsActivity() {
        val intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
    }

}
