package com.example.projecta.map

import android.util.Log
import com.example.projecta.firebase.authentication.FirebaseAuthenticationManager
import com.example.projecta.firebase.database.FirebaseDatabaseManager
import com.google.android.gms.maps.model.LatLng

class MapsRepositoryImpl() :MapsContract.repository {
    private val db : FirebaseDatabaseManager = FirebaseDatabaseManager()
    private val authentication: FirebaseAuthenticationManager = FirebaseAuthenticationManager()
    override fun addEmergency(location: LatLng) {
        val id = authentication.getUserId()
        db.createEmergency(id,location.latitude.toString(), location.longitude.toString()){isSuccessfull ->
            emergencyResult = isSuccessfull
        }
    }

    override var emergencyResult: Boolean = false
}