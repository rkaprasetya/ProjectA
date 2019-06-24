package com.example.projecta.register

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.projecta.R
import com.example.projecta.utilities.onTextChanged
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity(), RegisterContracts.view, View.OnClickListener {


    private var repository = RegisterRepositoryImpl()
    private var presenter : RegisterPresenterImpl = RegisterPresenterImpl(this,repository)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        initButtons()
    }

    private fun initButtons() {
        btn_register.setOnClickListener(this)
        et_email.onTextChanged { presenter.isEmailValid() }
        et_register_password.onTextChanged { presenter.isPasswordValid() }
        et_register_retype.onTextChanged { presenter.isPasswordValid() }
        btn_register_back.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btn_register->presenter.validateFields()
            R.id.btn_register_back->backToLogin()
        }
    }
    override fun showToast(message:String) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }


    override fun setPhoneNumberError() {
        et_phonenumber.error = resources.getString(R.string.empty_field)
    }

    override fun setEmailError(message:String) {
        et_email.error = message
    }

    override fun setPasswordError(message:String) {
        et_register_password.error = message
    }

    override fun setRetypeError(message:String) {
        et_register_retype.error = message
    }

    override fun setFullNameError() {
        et_fullname.error = resources.getString(R.string.empty_field)
    }

    override fun getFullName(): String {
        return et_fullname.text.toString().trim()
    }

    override fun getPhoneNumber(): String {
        return et_phonenumber.text.toString().trim()
    }

    override fun getEmail(): String {
        return et_email.text.toString().trim()
    }
    override fun getPassword():String {
       return et_register_password.text.toString().trim()
    }

    override fun getRetypePassword():String {
        return et_register_retype.text.toString().trim()
    }
    override fun unsetPasswordError() {
        et_register_password.error = null
    }

    override fun unsetRetypeError() {
        et_register_retype.error = null
    }

    override fun backToLogin() {
        finish()
    }
}
