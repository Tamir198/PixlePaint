package com.kotlin.pixlepaint

import android.content.Context
import pub.devrel.easypermissions.EasyPermissions
import android.Manifest.permission
import android.app.Activity
import android.util.Log
import pub.devrel.easypermissions.PermissionRequest


class CheckPermissions(private val context: Context, private val activity: Activity) {

    //todo check is the user accepted the permission and toast it


    fun storage(): Boolean {//checks for WRITE_EXTERNAL_STORAGE permission


        val perms = arrayOf(permission.READ_EXTERNAL_STORAGE)

        return if (EasyPermissions.hasPermissions(context, *perms)) {
            true
        } else {
            // Ask for  permissions
            EasyPermissions.requestPermissions(
                activity, "This app is asking for storage permission to save image to gallery",
                1, permission.READ_EXTERNAL_STORAGE)
            false
        }
    }
}