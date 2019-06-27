package com.example.projecta.map

import com.example.projecta.firebase.authentication.FirebaseAuthenticationManager
import com.example.projecta.firebase.database.FirebaseDatabaseManager
import com.google.android.gms.maps.model.LatLng

class MapsRepositoryImpl :MapsContract.repository {
    private val db : FirebaseDatabaseManager = FirebaseDatabaseManager()
    private val authentication: FirebaseAuthenticationManager = FirebaseAuthenticationManager()


    override fun addEmergency(location: LatLng,onResult: (Boolean) -> Unit){

        val id = authentication.getUserId()
        db.createEmergency(id,location.latitude.toString(), location.longitude.toString() ){isSuccessfull ->
        if(isSuccessfull){
            onResult(true)
        }else{
            onResult(false)
        }}

    }

    override var emergencyResult: Boolean = false
}