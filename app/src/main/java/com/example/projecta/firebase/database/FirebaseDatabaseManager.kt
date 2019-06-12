package com.example.projecta.firebase.database

import com.example.projecta.model.User
import com.google.firebase.database.FirebaseDatabase

class FirebaseDatabaseManager constructor(private val db:FirebaseDatabase = FirebaseDatabase.getInstance()):FirebaseDatabaseInterface {

    override fun createUser(id:String, username: String, email: String, phoneNumber: String, password: String) {
        val user = User(id, username, email, phoneNumber, password)
        db
            .reference
            .child(KEY_USER)
            .child(id)
            .setValue(user)

    }
    companion object{
        private const val KEY_USER = "user"

    }
}