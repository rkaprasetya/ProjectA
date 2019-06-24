package com.example.projecta.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.projecta.R
import com.example.projecta.home.HomeActivity
import com.example.projecta.register.RegisterActivity
import com.example.projecta.utilities.onTextChanged
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), LoginContract.view, View.OnClickListener {

    var presenter : LoginPresenterImpl = LoginPresenterImpl(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getUserSession()

    }

    private fun getUserSession(){
        if(presenter.checkUserSession()){
            openHomeActivity()
        }else{
            setContentView(R.layout.activity_login)
            initButtons()
        }
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btn_login_register -> openRegisterActivity()
            R.id.btn_login -> presenter.login()
        }
    }


    override fun setEmailError(message: String) {
        et_login_email.error = message
    }

    override fun setPasswordError(message: String) {
        et_login_password.error = message
    }
    private fun initButtons() {
        btn_login_register.setOnClickListener(this)
        btn_login.setOnClickListener(this)
        et_login_password.onTextChanged { presenter.isPasswordValid() }
    }

    override fun showToast(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }

    private fun openRegisterActivity() {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)

    }
    override fun getEmail(): String {
        return et_login_email.text.toString().trim()
    }

    override fun getPassword(): String {
        return et_login_password.text.toString().trim()
    }

    override fun openHomeActivity() {
        val intent = Intent(this,HomeActivity::class.java)
        startActivity(intent)
    }


}
