package com.example.projecta.Register

interface RegisterContracts {

    interface view{
        fun getFullName():String
        fun getPhoneNumber():String
        fun getEmail():String
        fun setPhoneNumberError()
        fun setEmailError()
        fun setFullNameError()
        fun keyUpEmail()
    }
    interface presenter{
        fun validateFields()
        fun String.isValidEmail():Boolean
    }
    interface repository{

    }
}