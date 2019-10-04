package com.kotlin.pixlepaint

import android.content.Context
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import pub.devrel.easypermissions.EasyPermissions
import pub.devrel.easypermissions.EasyPermissions.onRequestPermissionsResult
import android.R
import android.widget.Toast
import android.Manifest.permission
import android.Manifest.permission.READ_CONTACTS
import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.app.Activity


class CheckPermissions (private val context: Context,private val activity: Activity) {

    //todo check is the user accepted the permission and toast it



    fun storage(){//checks for WRITE_EXTERNAL_STORAGE permission

        val perms = arrayOf(permission.READ_EXTERNAL_STORAGE)

        if (EasyPermissions.hasPermissions(context, *perms)) {
            // Have permissions, do the thing!
           print("I have permission")
        } else {
            // Ask for both permissions
            EasyPermissions.requestPermissions(activity, "give me permission",1,"perms")
        }
    }
}