package com.example.projecta.login

import android.util.Patterns
import com.example.projecta.firebase.authentication.FirebaseAuthenticationManager

class LoginPresenterImpl(val view: LoginContract.view):LoginContract.presenter {

    private val authentication: FirebaseAuthenticationManager = FirebaseAuthenticationManager()

    override fun login() {
        val email = view.getEmail()
        val password = view.getPassword()
        if(validLogin(email,password)){

            authentication.login(email,password){isSuccess->
                if (isSuccess){
                    view.showToast("Login is successful")
                    view.openHomeActivity()
                }else{
                    view.showToast("Email/Password is incorrect")
                }
            }
        }
    }

    override fun checkUserSession():Boolean {
       return authentication.getUserSession()

    }

    private fun validLogin(email:String, password:String):Boolean{
        var valid = true
        if(!email.isValidEmail()){
            valid = false
            view.setEmailError("Email is invalid")
        }

        if(!isPasswordValid()){
            valid = false
        }

        return valid
    }
    override fun isPasswordValid():Boolean {
        if(view.getPassword().isEmpty()){
            view.setPasswordError("Password is empty")
            return false
        }
        return true
    }

    fun String.isValidEmail():Boolean = this.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()


}