package com.kotlin.pixlepaint

import android.content.Context
import androidx.core.content.ContextCompat

class CheckPermissions (private val context: ContextCompat) {

    //todo add permission check

    fun storage(): Boolean{//checks for WRITE_EXTERNAL_STORAGE permission
        return true

    }
}