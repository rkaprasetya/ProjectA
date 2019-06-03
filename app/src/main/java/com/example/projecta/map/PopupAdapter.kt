package com.example.projecta.map

import android.view.LayoutInflater
import android.view.View
import com.example.projecta.R
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Marker
import kotlinx.android.synthetic.main.popup_map.view.*

class PopupAdapter(var inflater: LayoutInflater) : GoogleMap.InfoWindowAdapter {

    private lateinit var popup: View

    override fun getInfoWindow(marker: Marker?): View? {
        return null
    }

    override fun getInfoContents(marker: Marker?): View {
        popup = inflater.inflate(R.layout.popup_map, null)
        if (marker!!.snippet != null) {
            popup.tv_popup_name.text = marker!!.snippet.toString()
            popup.ll_popup_name.visibility = View.VISIBLE
        }

        popup.tv_popup_title.text = marker!!.title.toString()
        return popup
    }
}