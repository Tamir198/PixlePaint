package com.kotlin.pixlepaint

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TableLayout
import android.widget.TableRow
import com.rtugeek.android.colorseekbar.ColorSeekBar
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.util.Log


class MainActivity : AppCompatActivity() {

    var currentColor = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configureTable()

        val mSeekBar = findViewById<ColorSeekBar>(R.id.seekBar)
        val someButton = findViewById<Button>(R.id.button12)

        mSeekBar.setOnColorChangeListener { colorBarPosition, alphaBarPosition, color ->
            someButton.setTextColor(color)
            currentColor = color
            Log.i("currentColor", "${mSeekBar.getColor(true)}")
        }



    }


    private fun configureTable() {
        //val table = TableLayout(this)
        val table = findViewById<TableLayout>(R.id.table)
        for (i in 0..10) {
            val row = TableRow(this)
            for (j in 0..19) {

                val cell = Button(this)
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
}







