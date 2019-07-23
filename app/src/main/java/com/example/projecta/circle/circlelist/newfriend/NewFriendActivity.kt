package com.example.projecta.circle.circlelist.newfriend

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.projecta.R
import kotlinx.android.synthetic.main.confirmation_dialog.view.*
import kotlinx.android.synthetic.main.search_friend_layout.*

class NewFriendActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.search_friend_layout)
        window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        initView()
    }
    private fun initView(){
        btn_search_close.setOnClickListener(this)
        btn_search_search.setOnClickListener(this)
        btn_search_add.setOnClickListener(this)
    }
    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btn_search_close -> finish()
            R.id.btn_search_search -> showResult()
            R.id.btn_search_add -> openConfirmationDialog()
        }
    }

    private fun openConfirmationDialog() {
        val dialog:AlertDialog
        val dialogView = LayoutInflater.from(this).inflate(R.layout.confirmation_dialog,null)
        val builder = AlertDialog.Builder(this)
        builder.setView(dialogView)
        dialog = builder.create()
        setConfirmationListener(dialogView,dialog)
        dialog.show()
    }

    private fun setConfirmationListener(dialogView : View, dialog : AlertDialog){
        dialogView.btn_confirmation_yes.setOnClickListener{
            finish()
        }
        dialogView.btn_confirmation_no.setOnClickListener{
            dialog.dismiss()
        }
    }

    private fun showResult() {
        rl_search_result.visibility = View.VISIBLE
        tv_search_result_title.visibility = View.VISIBLE
    }
}
