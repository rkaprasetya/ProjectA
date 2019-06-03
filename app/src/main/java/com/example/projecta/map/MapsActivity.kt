package com.example.projecta.map

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.projecta.BuildConfig
import com.example.projecta.R
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback, MapsContract.view {


    private lateinit var mMap: GoogleMap
    private var fusedLocationClient: FusedLocationProviderClient? = null
    protected var lastLocation: Location? = null
    private var latitudeLabel: Any? = null
    private var longitudeLabel: Any? = null
    private var presenter: MapsPresenterImpl? = MapsPresenterImpl(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

    }

    override fun getFusedLocationClient(): FusedLocationProviderClient? {
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        return fusedLocationClient
    }

    @SuppressLint("MissingPermission")
    override fun getLastLocation(mMap: GoogleMap) {
        getFusedLocationClient()!!.lastLocation.addOnCompleteListener(this) { task ->
            if (task.isSuccessful && task.result != null) {
                lastLocation = task.result

                latitudeLabel = lastLocation!!.latitude
                longitudeLabel = lastLocation!!.longitude

                //Add a marker in Sydney and move the camera
                val currentLocation = LatLng(lastLocation!!.latitude, lastLocation!!.longitude)
                val sydney = LatLng(-6.914744, 107.609810)
                val zoomLevel = 8.0f
                mMap.addMarker(
                    MarkerOptions().position(sydney)
                        .title("Person in distress")
                        .snippet("Rick, +6287762533")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
                )

                mMap.addMarker(
                    MarkerOptions().position(currentLocation)
                        .title("Your current location")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
                )
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, zoomLevel))
                mMap.setInfoWindowAdapter(PopupAdapter(layoutInflater))
            } else {
                Toast.makeText(this, "No location detected", Toast.LENGTH_SHORT).show()
            }
        }
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        presenter!!.setMap()
    }

    override fun getMap(): GoogleMap {
        return mMap
    }

    override fun getActivity(): Activity {
        return this
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter!!.onDestroy()
        presenter = null
    }

    override fun showSnackBar(textStringId: Int, actionStringId: Int, listener: View.OnClickListener) {
        Toast.makeText(this, getString(textStringId), Toast.LENGTH_LONG).show()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_PERMISSIONS_REQUEST_CODE) {
            if (grantResults.size <= 0) {
                Log.i(TAG, "User interaction was cancelled")
            } else if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getLastLocation(mMap)
            } else {
                showSnackBar(R.string.permission_denied_explanation, R.string.settings, View.OnClickListener {
                    val intent = Intent()
                    intent.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
                    val uri = Uri.fromParts("package", BuildConfig.APPLICATION_ID, null)
                    intent.data = uri
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                    startActivity(intent)
                })
            }
        }
    }

    companion object {
        private val TAG = "LocationProvider"
        private val REQUEST_PERMISSIONS_REQUEST_CODE = 34
    }
}
