package com.example.projecta.circle.circlelist.newfriend

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.projecta.R
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
    }
    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btn_search_close -> finish()
            R.id.btn_search_search -> showResult()
        }
    }

    private fun showResult() {
        rl_search_result.visibility = View.VISIBLE
        tv_search_result_title.visibility = View.VISIBLE
    }
}
