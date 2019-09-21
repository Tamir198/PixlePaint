package com.kotlin.pixlepaint

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TableLayout
import android.widget.TableRow
import com.rtugeek.android.colorseekbar.ColorSeekBar
import android.util.Log
import android.view.View
import android.widget.Toast


class MainActivity : AppCompatActivity(), View.OnClickListener, InitViews {

    private lateinit var smallTableBtn: Button
    private lateinit var mediumTableBtn: Button
    private lateinit var largeTableBtn: Button
    private lateinit var cameraBtn: Button
    private lateinit var deleteBtn: Button
    private lateinit var screenshotBtn: Button

    var currentColor = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        configureTable(5,8)
        currentSeekBarColor()
    }

    private fun currentSeekBarColor() {
        //saves the current picked color

        val mSeekBar = findViewById<ColorSeekBar>(R.id.seekBar)
        val someButton = findViewById<Button>(R.id.screenshot)
        mSeekBar.setOnColorChangeListener { colorBarPosition, alphaBarPosition, color ->
            someButton.setTextColor(color)
            currentColor = color
            Log.i("currentColor", "${mSeekBar.getColor(true)}")
        }

    }


    private fun configureTable( rows:Int,cellsInRow:Int) {
        val table = findViewById<TableLayout>(R.id.table)
        table.removeAllViews()
        for (rows in 0..rows) {
            val row = TableRow(this)
            for (cellsInRow in 0..cellsInRow) {

                val cell = Button(this)//create view for row
                clickTheCell(cell)
                configureCellLook(cell)
                row.addView(cell)
            }
            table.addView(row)
        }
    }

    private fun clickTheCell(cell: Button) {
        cell.setOnClickListener {
            cell.setTextColor(Color.WHITE)
            // cell.setTextColor(currentColor)
            cell.setBackgroundColor(currentColor)
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
                configureTable(5,3)
            }
            R.id.medium -> {
                configureTable(9,8)
            }
            R.id.large -> {
                configureTable(11,14)
            }
            R.id.camera -> {
                Toast.makeText(this, "camera clicked", Toast.LENGTH_SHORT).show()
            }
            R.id.delete -> {
                Toast.makeText(this, "delete clicked", Toast.LENGTH_SHORT).show()
            }
            R.id.screenshot -> {
                Toast.makeText(this, "screenshot clicked", Toast.LENGTH_SHORT).show()
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

        cameraBtn = findViewById(R.id.camera)
        cameraBtn.setOnClickListener(this)

        deleteBtn = findViewById(R.id.delete)
        deleteBtn.setOnClickListener(this)


        //todo check why this button is not clickable
        screenshotBtn = findViewById(R.id.delete)
        screenshotBtn.setOnClickListener(this)

    }
}







