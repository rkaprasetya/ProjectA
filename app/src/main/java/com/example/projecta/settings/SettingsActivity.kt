package com.example.projecta.settings

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.projecta.R
import com.example.projecta.circle.CircleActivity
import com.example.projecta.home.HomeActivity
import com.example.projecta.login.LoginActivity
import com.example.projecta.profile.ProfileActivity
import kotlinx.android.synthetic.main.activity_settings.*
import kotlinx.android.synthetic.main.dialog_logout.view.*


class SettingsActivity : AppCompatActivity(), View.OnClickListener, SettingsContracts.view {


    lateinit var dialog: AlertDialog
    var presenter : SettingsPresenterImpl? = SettingsPresenterImpl(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        initButtons()
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btn_settings_circle -> openCircleActivity()
            R.id.btn_settings_home -> openHomeActivity()
            R.id.btn_settings_profile -> openProfileActivity()
            R.id.btn_settings_logout -> openLogoutDialog()
            R.id.tv_logout_no -> dialog.dismiss()
            R.id.tv_logout_yes -> presenter?.signOut()
        }
    }

    private fun openLogoutDialog() {
        val builder = AlertDialog.Builder(this)
        val view = layoutInflater.inflate(R.layout.dialog_logout, null)
        builder.setView(view)
        dialog = builder.create()
        dialog.show()
        view.tv_logout_yes.setOnClickListener(this)
        view.tv_logout_no.setOnClickListener(this)
    }



    private fun openProfileActivity() {
        val intent = Intent(this, ProfileActivity::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }

    private fun openHomeActivity() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }

    private fun openCircleActivity() {
        val intent = Intent(this, CircleActivity::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }

    private fun initButtons() {
        btn_settings_circle.setOnClickListener(this)
        btn_settings_logout.setOnClickListener(this)
        btn_settings_home.setOnClickListener(this)
        btn_settings_circle.setOnClickListener(this)
        btn_settings_profile.setOnClickListener(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter = null
    }
    override fun openLoginActivity() {
        dialog.dismiss()
        val intent = Intent(this, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }
}
