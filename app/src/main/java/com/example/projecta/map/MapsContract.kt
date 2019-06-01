package com.example.projecta.map

import android.app.Activity
import android.view.View
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.maps.GoogleMap

interface MapsContract {
    interface view {
        fun getFusedLocationClient(): FusedLocationProviderClient?
        fun getMap(): GoogleMap
        fun getActivity(): Activity
        fun showSnackBar(textStringId: Int, actionStringId: Int, listener: View.OnClickListener)
        fun getLastLocation(mMap: GoogleMap)

    }
    interface presenter{
        fun setMap()
        fun onDestroy()

    }

}