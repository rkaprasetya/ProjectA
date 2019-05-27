package com.example.projecta.Register

import android.util.Patterns
import java.util.regex.Pattern

class RegisterPresenterImpl(var view:RegisterContracts.view): RegisterContracts.presenter {
    override fun validateFields() {
        var result = true;

        if(view.getFullName() == ""){
            view.setFullNameError()
            result = false
        }
        if(view.getEmail() == ""){
            view.setEmailError()
            result = false
        }
        if(view.getPhoneNumber() == ""){
            view.setPhoneNumberError()
            result = false
        }
        if(result){

        }
    }

    override fun String.isValidEmail():Boolean = this.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()


}