package com.example.projecta.circle

import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.projecta.R
import com.example.projecta.circle.circlelist.FriendFragment
import com.example.projecta.circle.circlelist.MyCircleFragment
import com.example.projecta.home.HomeActivity
import com.example.projecta.profile.ProfileActivity
import com.example.projecta.settings.SettingsActivity
import kotlinx.android.synthetic.main.activity_circle.*

class CircleActivity : AppCompatActivity(), CircleContracts.view,
    View.OnClickListener {
    lateinit var dialog: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_circle)
        viewPager.adapter = CircleAdapter(supportFragmentManager)
        initButtons()
        setStatePageAdapter()
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

    private fun setStatePageAdapter(){
        val adapter = CircleAdapter(supportFragmentManager)
        adapter.addFragment(MyCircleFragment(), "My Circle")
        adapter.addFragment(FriendFragment(), "Friend Circle")
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)
        //tabLayout.setTabTextColors(Color.parseColor("#133337"), Color.parseColor("#36a3f7"))

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

     fun openSettingsActivity() {
        val intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
    }

}
