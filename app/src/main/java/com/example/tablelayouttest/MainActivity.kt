package com.example.tablelayouttest

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.core.view.marginLeft
import androidx.core.view.setPadding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addAndroidVersion()
    }

    fun addAndroidVersion() {
        val addAndroid = findViewById<Button>(R.id.addAndroidVersion);

        addAndroid.setOnClickListener {
            val params = TableLayout.LayoutParams(
                TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.WRAP_CONTENT
            )
            val code = findViewById<EditText>(R.id.androidCode);
            val version = findViewById<EditText>(R.id.androidVersion);
            val newRow = TableRow(this);
            val table = findViewById<TableLayout>(R.id.table);
            newRow.layoutParams = params

            val rowParam = TableRow.LayoutParams(0, TableRow.LayoutParams.WRAP_CONTENT, 1.0f)
            val border = GradientDrawable()
            border.setColor(Color.parseColor("#FF7276")) // Set the background color
            border.setStroke(2, Color.BLACK)

            val newCode = TextView(this);
            newCode.text = code.text;
            newCode.layoutParams = rowParam;
            newCode.background = border
            newCode.setPadding(50, 0, 0, 0);
            val newVersion = TextView(this);
            newVersion.text = version.text;
            newVersion.layoutParams = rowParam;
            newVersion.background = border
            newVersion.setPadding(50, 0, 0, 0);

            newRow.addView(newVersion);
            newRow.addView(newCode);
            table.addView(newRow)
        };
    }
}