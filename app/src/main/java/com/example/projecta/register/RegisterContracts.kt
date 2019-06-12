package com.example.projecta.register

interface RegisterContracts {

    interface view{
        fun getFullName():String
        fun getPhoneNumber():String
        fun getEmail():String
        fun setPhoneNumberError()
        fun setEmailError(message:String)
        fun setFullNameError()
        fun setPasswordError(message:String)
        fun setRetypeError(message:String)
        fun showToast()
        fun getPassword():String
        fun getRetypePassword():String
        fun unsetPasswordError()
        fun unsetRetypeError()

    }
    interface presenter{
        fun validateFields()
        fun String.isValidEmail():Boolean
        fun isEmailValid()
        fun isPasswordValid()

    }
    interface repository{

    }
}