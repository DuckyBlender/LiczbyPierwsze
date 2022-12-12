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

        fun liczbyPierwsze(input: Int): String {
            var arrayInt = arrayOf<Int>()
            var x = input
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
            return arrayInt.joinToString()
        }

        button.setOnClickListener() {
            // Check if input is empty
            if (input.text.toString().isEmpty()) {
                text.text = "Wpisz liczbę"
            } else {
                text.text = liczbyPierwsze(input.text.toString().toInt())
            }
        }
    }
}