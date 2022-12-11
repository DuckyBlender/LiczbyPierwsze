package com.example.liczbypierwsze

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.sqrt
import kotlin.math.floor

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var button = findViewById<Button>(R.id.button)
        var input = findViewById<EditText>(R.id.inputNumber)
        var text = findViewById<TextView>(R.id.wynik)

        button.setOnClickListener() {
            var arrayInt = arrayOf<Int>()
            var x = input.text.toString().toInt()
            var y = 2
            var z = floor(sqrt(x.toFloat().toDouble()))
            while (y <= z) {
                while (x % y == 0) {
                    arrayInt += y
                    x /= y
                    z = floor(sqrt((x.toFloat().toDouble())))
                }
                y += 1
            }
            if (x > 1) {
                arrayInt += x
            }
            var results = arrayInt.contentToString().replace("[", "").replace("]", "")
            text.text = results
        }
    }
}