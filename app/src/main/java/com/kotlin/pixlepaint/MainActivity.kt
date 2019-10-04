package com.kotlin.pixlepaint

import android.content.ContentResolver
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rtugeek.android.colorseekbar.ColorSeekBar
import android.util.Log
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import com.abdallahalaraby.blink.Screenshot
import android.os.Environment
import android.provider.MediaStore
import androidx.core.content.ContextCompat
import java.io.File
import java.io.FileOutputStream
import java.util.jar.Manifest


class MainActivity : AppCompatActivity(), View.OnClickListener, InitViews {

    private lateinit var smallTableBtn: Button
    private lateinit var mediumTableBtn: Button
    private lateinit var largeTableBtn: Button
    private lateinit var undoBtn: Button
    private lateinit var deleteBtn: ImageView
    private lateinit var lastColorBtn: Button
    private lateinit var eraser: Button

    private var currentColor = 0
    private var undoColor = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        configureTable(11, 14)
        currentSeekBarColor()


    }

    private fun currentSeekBarColor() {
        //saves the current picked color

        val mSeekBar = findViewById<ColorSeekBar>(R.id.seekBar)
        mSeekBar.setOnColorChangeListener { colorBarPosition, alphaBarPosition, color ->
            currentColor = color
            Log.i("currentColor", "${mSeekBar.getColor(true)}")
        }

    }


    private fun configureTable(rows: Int, cellsInRow: Int) {
        val table = findViewById<TableLayout>(R.id.table)
        table.removeAllViews()
        for (rows in 0..rows) {
            val row = TableRow(this)
            for (cellsInRow in 0..cellsInRow) {
                val cell = Button(this)//create view for row
                configureCellLook(cell)
                clickTheCell(cell)

                row.addView(cell)
            }
            table.addView(row)
        }

    }

    private fun clickTheCell(cell: Button) {
        cell.setOnClickListener {
            cell.setTextColor(Color.BLACK)
            // cell.setTextColor(currentColor)
            cell.setBackgroundColor(currentColor)
            //saves the last color for the "undo" button
            undoColor = currentColor
            lastColorBtn.setBackgroundColor(currentColor)
        }
    }

    private fun configureCellLook(cell: Button) {
        //When setting setLayoutParams it refers to the parent,
        //use TableRow.LayoutParams and not ViewGroup
        cell.layoutParams = TableRow.LayoutParams(
            TableRow.LayoutParams.MATCH_PARENT,
            TableRow.LayoutParams.MATCH_PARENT
        )

        cell.text = "."
        cell.setTextColor(Color.BLACK)
        cell.setBackgroundColor(Color.WHITE)

    }

    override fun onClick(v: View?) {//when a button is clicked
        when (v?.id) {
            R.id.small -> {
                configureTable(5, 3)
                highlightBtn(R.id.small)

            }
            R.id.medium -> {
                configureTable(9, 8)
                highlightBtn(R.id.medium)
            }
            R.id.large -> {
                configureTable(11, 14)
                highlightBtn(R.id.large)
            }
            R.id.camera -> {
                val bitmap = Screenshot.getInstance().takeScreenshotForView(findViewById(R.id.table)) // Take Screenshot for View
                deleteBtn.setImageBitmap(bitmap)
                SaveImage(bitmap,"PixelPaint","nice",this).saveImage()
            }

            R.id.delete -> {
                Toast.makeText(this, "delete clicked", Toast.LENGTH_SHORT).show()
            }
            R.id.returnLastColor -> {
                seekBar.color = undoColor
            }
            R.id.eraser ->{
                Toast.makeText(this, "White", Toast.LENGTH_SHORT).show()
                currentColor = Color.WHITE
            }

        }
    }


    override fun initViews() {
        smallTableBtn = findViewById(R.id.small)
        smallTableBtn.setOnClickListener(this)

        mediumTableBtn = findViewById(R.id.medium)
        mediumTableBtn.setOnClickListener(this)

        largeTableBtn = findViewById(R.id.large)
        largeTableBtn.setOnClickListener(this)

        undoBtn = findViewById(R.id.camera)
        undoBtn.setOnClickListener(this)

        deleteBtn = findViewById(R.id.delete)
        deleteBtn.setOnClickListener(this)

        lastColorBtn = findViewById(R.id.returnLastColor)
        lastColorBtn.setOnClickListener(this)

        eraser = findViewById(R.id.eraser)
        eraser.setOnClickListener(this)



    }

    private fun highlightBtn(highlighted: Int) { //place border on the chosen table button
        when (highlighted) {
            R.id.small -> {
                smallTableBtn.background = getDrawable(R.drawable.selected_button)
                mediumTableBtn.background = getDrawable(R.drawable.non_selected_button)
                largeTableBtn.background = getDrawable(R.drawable.non_selected_button)

            }
            R.id.medium -> {
                mediumTableBtn.background = getDrawable(R.drawable.selected_button)
                smallTableBtn.background = getDrawable(R.drawable.non_selected_button)
                largeTableBtn.background = getDrawable(R.drawable.non_selected_button)

            }
            R.id.large -> {
                largeTableBtn.background = getDrawable(R.drawable.selected_button)
                smallTableBtn.background = getDrawable(R.drawable.non_selected_button)
                mediumTableBtn.background = getDrawable(R.drawable.non_selected_button)

            }

        }
    }
}







