package com.example.projecta.circle

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.projecta.R
import com.example.projecta.home.HomeActivity
import com.example.projecta.profile.ProfileActivity
import kotlinx.android.synthetic.main.activity_circle.*
import kotlinx.android.synthetic.main.dialog_logout.view.*

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
        btn_circle_logout.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btn_circle_home -> openHomeActivity()
            R.id.btn_circle_profile -> openProfileActivity()
            R.id.tv_logout_yes -> dialog.dismiss()
            R.id.tv_logout_no -> dialog.dismiss()
            R.id.btn_circle_logout -> openLogoutDialog()
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
