package com.example.projecta.register

import android.util.Patterns

class RegisterPresenterImpl(var view:RegisterContracts.view): RegisterContracts.presenter {

    var result = true;
    override fun isEmailValid() {

        if(view.getEmail().isEmpty()){
            view.setEmailError( "Please fill this field")
            result = false
        }else if(!view.getEmail().isValidEmail()){
            view.setEmailError("Email address is invalid")
            result = false
        }
    }

    override fun validateFields() {
        result = true

        if(view.getFullName() == ""){
            view.setFullNameError()
            result = false
        }
        isEmailValid()
        if(view.getPhoneNumber() == ""){
            view.setPhoneNumberError()
            result = false
        }

        isPasswordValid()

        if(result){
            view.showToast()
        }
    }
    override fun isPasswordValid() {

        val password = view.getPassword()
        val retype = view.getRetypePassword()
        if(password.isEmpty()){
            view.setPasswordError("Please fill this field")
            result = false
        }else if(retype.isEmpty()){
            view.setRetypeError("Please fill this field")
            result = false
        }else if(password != retype){
            view.setPasswordError("Password does not match")
            view.setRetypeError("Password does not match")
            result = false
        }else{
            view.unsetPasswordError()
            view.unsetRetypeError()
        }
    }

    override fun String.isValidEmail():Boolean = this.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()


}