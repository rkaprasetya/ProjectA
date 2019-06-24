package com.example.projecta.login

import com.example.projecta.base.BaseContracts

interface LoginContract {
    interface view:BaseContracts.view{
        fun getEmail():String
        fun getPassword():String
        fun setEmailError(message:String)
        fun setPasswordError(message:String)
        fun showToast(message:String)
        fun openHomeActivity()
    }

    interface presenter{
        fun login()
        fun isPasswordValid():Boolean
        fun checkUserSession():Boolean

    }
    interface repository{

    }
}