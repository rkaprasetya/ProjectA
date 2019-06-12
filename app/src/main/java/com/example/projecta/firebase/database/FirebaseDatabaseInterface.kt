package com.example.projecta.firebase.database

interface FirebaseDatabaseInterface {

    fun createUser(id:String, username: String, email:String,phoneNumber:String, password:String)
}