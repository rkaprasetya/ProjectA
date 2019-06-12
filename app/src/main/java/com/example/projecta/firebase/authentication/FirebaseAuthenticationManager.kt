package com.example.projecta.firebase.authentication

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.UserProfileChangeRequest

class FirebaseAuthenticationManager constructor(val authentication : FirebaseAuth = FirebaseAuth.getInstance()): FirebaseAuthenticationInterface {

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