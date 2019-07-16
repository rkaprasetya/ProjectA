package com.example.projecta.firebase.database

import com.example.projecta.model.User

interface FirebaseDatabaseInterface {

    fun createUser(id:String, username: String, email:String,phoneNumber:String, password:String):Boolean
    fun createEmergency(id:String, latitude : String, longitude:String, onResult: (Boolean) -> Unit)
    fun createCircle(id:String, circleName:String, onResult: (Boolean) -> Unit)
    fun getCircle(id:String, onResult: (Any?) -> Unit)
}