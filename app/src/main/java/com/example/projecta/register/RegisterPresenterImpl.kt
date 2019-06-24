package com.example.projecta.register

import android.util.Log
import android.util.Patterns
import com.example.projecta.firebase.authentication.FirebaseAuthenticationManager

class RegisterPresenterImpl(var view:RegisterContracts.view, var repository: RegisterContracts.repository): RegisterContracts.presenter {
    private val authentication: FirebaseAuthenticationManager = FirebaseAuthenticationManager()
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
        val fullname = view.getFullName()
        val phoneNumber = view.getPhoneNumber()
        val password = view.getPassword()
        val email = view.getEmail()
        if(fullname == ""){
            view.setFullNameError()
            result = false
        }
        isEmailValid()
        if(phoneNumber == ""){
            view.setPhoneNumberError()
            result = false
        }

        isPasswordValid()
        if(result){
            authentication.register(email,password,fullname,phoneNumber) { isSuccessful ->
                onRegisterResult(isSuccessful,fullname,phoneNumber,email,password)
            }
//             repository.registerUser(fullname,phoneNumber,email,password)

        }else{
            view.showToast("Form is not filled correctly")
        }


    }
    fun onRegisterResult(userResult: Boolean,fullname: String, phoneNumber: String, email: String, password: String) {
        if(userResult){
            if(repository.createUser(fullname,phoneNumber,email,password)){
                view.showToast("Register is successfull")
                view.backToLogin()
            }
        }else{
            view.showToast("Email is registered. Please use another email")
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