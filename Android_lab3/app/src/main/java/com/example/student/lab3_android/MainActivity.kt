package com.example.student.lab3_android

import android.content.Context
import android.content.pm.PackageManager
import android.location.LocationManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var myDatabaseHelper =MyDatabaseHelper(this)

        var permission = android.Manifest.permission.ACCESS_FINE_LOCATION
        button3.setOnClickListener{
            if(ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED){

                var locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager

                var locationListener = MyLocationListener()
                locationListener.myOnLocationChangeListener = {

                    myDatabaseHelper.insert(it.toString())
                    var adapter = ArrayAdapter<String>(this,R.layout.widok,myDatabaseHelper.selectAll())
                    listView.adapter = adapter

                }

                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1f, locationListener)
            }else{
                ActivityCompat.requestPermissions(this,arrayOf(permission), 0)
            }
        }
    }
}
