package com.kotlin.pixlepaint
import android.content.Context
import android.graphics.Bitmap
import android.provider.MediaStore


class SaveImage(
    private val bitmap: Bitmap, private val title: String,
    private val description: String, private val context: Context
) {

    fun saveImage() { //saves image to gallery
        println("Save image called")
        MediaStore.Images.Media.insertImage(
            context.contentResolver,
            bitmap, title,
            description
        )
    }
}
