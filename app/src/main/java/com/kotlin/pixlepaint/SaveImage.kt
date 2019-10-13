package com.kotlin.pixlepaint
import android.app.Activity
import android.content.Context
import android.graphics.Bitmap
import android.provider.MediaStore
import android.widget.Toast


class SaveImage(
    private val bitmap: Bitmap, private val title: String,
    private val description: String, private val context: Context, private val activity:Activity) {

    fun saveImage() { //saves image to gallery
        println("Save image called")

        Toast.makeText(context,"Saving Image",Toast.LENGTH_LONG).show()


        MediaStore.Images.Media.insertImage(
            context.contentResolver,
            bitmap, title,
            description)

    }
}
