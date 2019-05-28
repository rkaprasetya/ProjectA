package com.example.projecta.register

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.projecta.R
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity(), RegisterContracts.view, View.OnClickListener {
    override fun keyUpEmail() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    private var presenter : RegisterPresenterImpl = RegisterPresenterImpl(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btn_register->{
                onClickRegister()
            }
        }
    }
    private fun onClickRegister(){
        presenter.validateFields()
    }

    override fun setPhoneNumberError() {
        et_phonenumber.error = resources.getString(R.string.empty_field)
    }

    override fun setEmailError() {
        et_email.error = resources.getString(R.string.empty_field)
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
}
