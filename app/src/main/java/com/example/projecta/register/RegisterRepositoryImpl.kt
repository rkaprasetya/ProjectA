package com.example.projecta.register

import com.example.projecta.firebase.authentication.FirebaseAuthenticationManager
import com.example.projecta.firebase.database.FirebaseDatabaseManager

class RegisterRepositoryImpl: RegisterContracts.repository {


    private val db : FirebaseDatabaseManager = FirebaseDatabaseManager()
    private val authentication: FirebaseAuthenticationManager = FirebaseAuthenticationManager()
    var result = false
    override fun registerUser(
        fullname: String,
        phoneNumber: String,
        email: String,
        password: String) {

        authentication.register(email,password,fullname,phoneNumber) { isSuccessful ->
            onRegisterResult(isSuccessful,fullname,phoneNumber,email,password)

        }


    }

    private fun onRegisterResult(userResult: Boolean,fullname: String, phoneNumber: String, email: String, password: String){
        if(userResult){
            createUser(fullname,phoneNumber,email,password)
            result = true
        }else{
            result = false
        }

    }

    override fun createUser(fullname: String, phoneNumber: String, email: String, password: String):Boolean {
        val id = authentication.getUserId()
        return db.createUser(id,fullname,email, phoneNumber,password)

    }
}