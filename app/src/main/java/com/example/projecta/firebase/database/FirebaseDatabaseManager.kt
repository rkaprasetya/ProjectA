package com.example.projecta.firebase.database


import com.example.projecta.model.Emergency
import com.example.projecta.model.User
import com.google.firebase.database.FirebaseDatabase


class FirebaseDatabaseManager:FirebaseDatabaseInterface {
    override fun createEmergency(
        id: String,
        latitude: String,
        longitude: String,
        onResult: (Boolean) -> Unit
    ) {
        val emergency = Emergency(id, latitude,longitude)
        db.reference.child(KEY_EMERGENCY)
            .child(id)
            .setValue(emergency)
            .addOnCompleteListener{onResult(it.isSuccessful && it.isComplete)}


    }


    private val db:FirebaseDatabase = FirebaseDatabase.getInstance()
    override fun createUser(id:String, username: String, email: String, phoneNumber: String, password: String):Boolean {
        val user = User(id, username, email, phoneNumber, password)
        db
            .reference
            .child(KEY_USER)
            .child(id)
            .setValue(user)
        return true
    }

    companion object{
        private const val KEY_USER = "user"
        private const val KEY_EMERGENCY = "emergency"
    }
}