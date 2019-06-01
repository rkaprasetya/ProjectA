package com.example.projecta.map

import android.Manifest
import android.content.pm.PackageManager
import android.support.v4.app.ActivityCompat
import android.util.Log
import android.view.View
import com.example.projecta.R

class MapsPresenterImpl(var view:MapsContract.view?):MapsContract.presenter {

    override fun setMap() {
        if(!checkPermissions()){
            requestPermissions()
        }else{
            view!!.getLastLocation(view!!.getMap())
        }
    }

    private fun requestPermissions() {
        val shouldProvideRationale =
            ActivityCompat.shouldShowRequestPermissionRationale(view!!.getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION)
        if (shouldProvideRationale) {
            Log.i(TAG, "Displaying permission rationale to provide additional context")
            view!!.showSnackBar(R.string.permission_rationale, android.R.string.ok, View.OnClickListener {
                startLocationPermissionRequest()
            })
        } else {
            Log.i(TAG, "Requesting Permission")
            startLocationPermissionRequest()
        }
    }

    private fun checkPermissions(): Boolean {
        val permissionState = ActivityCompat.checkSelfPermission(view!!.getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION)
        return permissionState == PackageManager.PERMISSION_GRANTED
    }

    private fun startLocationPermissionRequest() {
        ActivityCompat.requestPermissions(
            view!!.getActivity(), arrayOf((Manifest.permission.ACCESS_COARSE_LOCATION)),
            REQUEST_PERMISSIONS_REQUEST_CODE
        )
    }
    override fun onDestroy() {
        view = null
    }


    companion object {
        private val TAG = "LocationProvider"
        private val REQUEST_PERMISSIONS_REQUEST_CODE = 34
    }
}