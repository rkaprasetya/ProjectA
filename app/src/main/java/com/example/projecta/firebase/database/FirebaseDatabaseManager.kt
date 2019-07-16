package com.example.projecta.firebase.database


import com.example.projecta.model.Circle
import com.example.projecta.model.Emergency
import com.example.projecta.model.User
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class FirebaseDatabaseManager:FirebaseDatabaseInterface {


    private val db:FirebaseDatabase = FirebaseDatabase.getInstance()

    override fun getCircle(id: String, onResult: (Any?) -> Unit) {
        val dbRef = db.reference
        dbRef
            .child(KEY_CIRCLE)
            .child(id)
            .addListenerForSingleValueEvent (
                object : ValueEventListener {
                    override fun onCancelled(p0: DatabaseError) {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                       val user =  dataSnapshot.getValue(User::class.java)
                        onResult(user)
                    }



            })


    }

    override fun createCircle(id: String, circleName: String, onResult: (Boolean) -> Unit) {
        val circle = Circle(id,circleName)
        db
            .reference
            .child(KEY_CIRCLE)
            .child(id)
            .setValue(circle)
            .addOnCompleteListener{onResult(it.isSuccessful && it.isComplete)}
    }


    override fun createUser(id:String, username: String, email: String, phoneNumber: String, password: String):Boolean {
        val user = User(id, username, email, phoneNumber, password)
        db
            .reference
            .child(KEY_USER)
            .child(id)
            .setValue(user)

        return true
    }
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



    companion object{
        private const val KEY_USER = "user"
        private const val KEY_EMERGENCY = "emergency"
        private const val KEY_CIRCLE = "circle"
    }
}