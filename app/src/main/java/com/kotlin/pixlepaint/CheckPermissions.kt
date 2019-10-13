package com.kotlin.pixlepaint
import android.content.Context
import pub.devrel.easypermissions.EasyPermissions
import android.Manifest.permission
import android.app.Activity

class CheckPermissions(private val context: Context, private val activity: Activity) {



    fun storage(): Boolean {//checks for WRITE_EXTERNAL_STORAGE permission


        val perms = arrayOf(permission.WRITE_EXTERNAL_STORAGE)

        return if (EasyPermissions.hasPermissions(context, *perms)) {
            true
        } else {
            // Ask for  permissions
            EasyPermissions.requestPermissions(
                activity, "This app is asking for storage permission to save image to gallery",
                1, permission.WRITE_EXTERNAL_STORAGE)
            false
        }
    }
}