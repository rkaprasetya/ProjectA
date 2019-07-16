package com.example.projecta.circle.circlelist.mycircle

import com.example.projecta.firebase.authentication.FirebaseAuthenticationManager
import com.example.projecta.firebase.database.FirebaseDatabaseManager

class MyCirclePresenterImpl(val view : MyCircleContracts.view):MyCircleContracts.presenter {
    private val db : FirebaseDatabaseManager = FirebaseDatabaseManager()
    private val authentication: FirebaseAuthenticationManager = FirebaseAuthenticationManager()

    override fun getCircle() {
        val id = authentication.getUserId()
        db.getCircle(id){
            user ->
            if(user == null){

            }else{

            }
        }
    }
}