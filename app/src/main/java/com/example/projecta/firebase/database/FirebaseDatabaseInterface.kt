package com.example.projecta.firebase.database

interface FirebaseDatabaseInterface {

    fun createUser(id:String, username: String, email:String,phoneNumber:String, password:String):Boolean
    fun createEmergency(id:String, latitude : String, longitude:String, onResult: (Boolean) -> Unit)
}