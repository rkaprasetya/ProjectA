package com.example.projecta.firebase.authentication

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest

class FirebaseAuthenticationManager : FirebaseAuthenticationInterface {

    val authentication : FirebaseAuth = FirebaseAuth.getInstance()
    override fun getUserId(): String  = authentication.currentUser?.uid ?:""

    override fun register(email: String, password: String, username: String, phoneNumber: String, onResult: (Boolean)->Unit) {
        authentication.createUserWithEmailAndPassword(email,password).addOnCompleteListener {
            if(it.isComplete && it.isSuccessful){
                authentication.currentUser?.updateProfile(UserProfileChangeRequest.Builder()
                    .setDisplayName(username)
                    .build())
                onResult(true)

            }else{
                onResult(false)

            }

        }
    }

}