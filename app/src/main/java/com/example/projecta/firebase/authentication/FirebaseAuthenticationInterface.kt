package com.example.projecta.firebase.authentication

interface FirebaseAuthenticationInterface {

    fun register(email:String, password:String, username:String, phoneNumber:String,onResult:(Boolean)->Unit)
    fun getUserId(): String
}