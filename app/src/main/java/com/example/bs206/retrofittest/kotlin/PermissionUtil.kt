package com.example.bs206.retrofittest.kotlin

import android.Manifest
import android.app.Activity
import android.content.ContentValues.TAG
import android.content.Context
import android.content.pm.PackageManager
import android.support.design.widget.Snackbar
import android.support.v4.app.ActivityCompat
import android.support.v4.app.ActivityCompat.checkSelfPermission
import android.util.Log
import android.view.View
import com.example.bs206.retrofittest.R
import com.example.bs206.retrofittest.kotlin.Constants.Companion.REQUEST_CAMERA_PERMISSIONS_REQUEST_CODE
import com.example.bs206.retrofittest.kotlin.Constants.Companion.REQUEST_LOCATION_PERMISSIONS_REQUEST_CODE

fun checkLocationPermissions(context : Context): Boolean
{
    val permissionState = checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION)
    return permissionState == PackageManager.PERMISSION_GRANTED
}
fun checkCameraPermissions(context : Context): Boolean
{
    val permissionState = checkSelfPermission(context, Manifest.permission.CAMERA)
    return permissionState == PackageManager.PERMISSION_GRANTED
}

fun requestLocationPermissions(context: Context)
{
    if(context is Activity)
    {
        val shouldProvideRationale = ActivityCompat.shouldShowRequestPermissionRationale(context,
                Manifest.permission.ACCESS_COARSE_LOCATION)

        if (shouldProvideRationale)
        {
            Log.i(TAG, "Displaying permission rationale to provide additional context.")

/*            showSnackbar(context, R.string.permission_rationale, android.R.string.ok,
                    View.OnClickListener {
                        // Request permission
                        startLocationPermissionRequest(context)
                    })*/

            startLocationPermissionRequest(context)

        }
        else
        {
            Log.i(TAG, "Requesting permission")
            startLocationPermissionRequest(context)
        }
    }

}
fun requestCameraPermissions(context: Context)
{
    if(context is Activity)
    {
        val shouldProvideRationale = ActivityCompat.shouldShowRequestPermissionRationale(context,
                Manifest.permission.CAMERA)

        if (shouldProvideRationale)
        {
            Log.i(TAG, "Displaying permission rationale to provide additional context.")

/*            showSnackbar(context, R.string.permission_rationale, android.R.string.ok,
                    View.OnClickListener {
                        // Request permission
                        startLocationPermissionRequest(context)
                    })*/

            startCameraPermissionRequest(context)

        }
        else
        {
            Log.i(TAG, "Requesting permission")
            startCameraPermissionRequest(context)
        }
    }

}
/*fun showSnackbar(context: Context,mainTextStringId: Int, actionStringId: Int, listener: View.OnClickListener)
{
    Snackbar.make(android.R.id.content,
            mainTextStringId,
            Snackbar.LENGTH_INDEFINITE)
            .setAction(actionStringId, listener).show()
}*/

fun startLocationPermissionRequest(context: Context)
{

    if (context is Activity)
    {
        ActivityCompat.requestPermissions(context,
                arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION),
                REQUEST_LOCATION_PERMISSIONS_REQUEST_CODE)
    }

}

fun startCameraPermissionRequest(context: Context)
{

    if (context is Activity)
    {
        ActivityCompat.requestPermissions(context,
                arrayOf(Manifest.permission.CAMERA),
                REQUEST_CAMERA_PERMISSIONS_REQUEST_CODE)
    }

}