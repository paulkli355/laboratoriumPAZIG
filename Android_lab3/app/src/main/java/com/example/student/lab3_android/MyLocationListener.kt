package com.example.student.lab3_android

import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle

/**
 * Created by student on 2020-01-15.
 */
class MyLocationListener : LocationListener {

    lateinit var myOnLocationChangeListener:(Float?) -> Unit
    var lastLocation : Location? = null

    override fun onLocationChanged(p0: Location?) {
        if(lastLocation == null){
            lastLocation = p0
        }
        var distance = p0?.distanceTo(lastLocation)
        myOnLocationChangeListener(distance)

        lastLocation = p0
    }

    override fun onStatusChanged(p0: String?, p1: Int, p2: Bundle?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onProviderEnabled(p0: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onProviderDisabled(p0: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}