package com.kotlin.pixlepaint

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TableLayout
import android.widget.TableRow



class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val table = TableLayout(this)
        val table = findViewById<TableLayout>(R.id.table)
        table.weightSum = 10.0F
        for (i in 0..9) {
            var row = TableRow(this)
            for (j in 0..19) {
                val cell = Button(this)

                cell.setOnClickListener(View.OnClickListener {
                    cell.setTextColor(Color.WHITE)
                    cell.setBackgroundColor(Color.BLACK)

                })


                //When setting setLayoutParams it refers to the parent,
                //use TableRow.LayoutParams and not ViewGroup
                cell.layoutParams =  TableRow.LayoutParams(
                   //   table.width/5,
                   // table.height/10,

                    TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.MATCH_PARENT
                )

                cell.text = "."
                cell.setTextColor(Color.RED)
                cell.setBackgroundColor(Color.WHITE)
                cell.setPadding(0, 0, 0, 0)

                row.addView(cell)
            }

            table.addView(row)
        }


    }

    //makes the table disappear
    // table.width/5,
    // table.height/10
}
