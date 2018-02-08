package com.example.bs206.retrofittest.kotlin

import android.content.Intent
import android.location.Location
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.util.Log
import android.view.View
import com.example.bs206.retrofittest.R
import com.example.bs206.retrofittest.java.a.VerticalListActivity
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()
{

    private lateinit var mFusedLocationClient: FusedLocationProviderClient
    protected lateinit var mLastLocation: Location

    private var deviceLatitude = 0.0
    private var deviceLongitude = 0.0


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        vertical_list_btn.setOnClickListener{

            val intent = Intent(this, VerticalListActivity::class.java)
            intent.putExtra(Constants.DEVICE_LATI, deviceLatitude)
            intent.putExtra(Constants.DEVICE_LONGI, deviceLongitude)
            startActivity(intent)
        }

        viewpager_btn.setOnClickListener {
            val intentViewPager = Intent(this, ViewPagerActivity::class.java)
            startActivity(intentViewPager)
        }


        place_image_on_imageview_btn.setOnClickListener {
            val intentcameraImage = Intent(this, CameraImageActivity::class.java)
            startActivity(intentcameraImage)
        }
    }

    override fun onStart()
    {
        super.onStart()

        if (!checkLocationPermissions(this))
        {
            requestLocationPermissions(this)
        }
        if (!checkCameraPermissions(this))
        {
            requestCameraPermissions(this)
        }
        else
            getLastLocation()


    }

    private fun getLastLocation()
    {
        mFusedLocationClient.getLastLocation()
                .addOnCompleteListener(this, { task ->

                    if (task.isSuccessful && task.result != null)
                    {
                        mLastLocation = task.result

                        deviceLatitude = mLastLocation.getLatitude()
                        deviceLongitude = mLastLocation.getLongitude()

                        Log.v(Constants.TAG, "device latitude $deviceLatitude and longitude $deviceLongitude")
                    }
                    else
                    {
                        Log.w(Constants.TAG, "getLastLocation:exception", task.exception)
                        showSnackbar(getString(R.string.no_location_detected))
                    }
                })
    }

    private fun showSnackbar(text: String)
    {
        val container = findViewById<View>(R.id.main_activity_container)
        if (container != null)
        {
            Snackbar.make(container, text, Snackbar.LENGTH_LONG).show()
        }
    }

    /*private fun showSnackbar(mainTextStringId: Int, actionStringId: Int, listener: View.OnClickListener)
    {
        Snackbar.make(findViewById(android.R.id.content),
                getString(mainTextStringId),
                Snackbar.LENGTH_INDEFINITE)
                .setAction(getString(actionStringId), listener).show()
    }*/

}
