package com.example.imadpracticum

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailedViewScreen : AppCompatActivity() {

    val days = arrayOf("Sunday: 10-20 Sunny", "Monday: 11-21 Cloudy", "Tuesday: 12-22 Windy", "Wednesday: 13-23 Rainy", "Thursday: 14-24 Windy", "Friday: 15-25 Cloudy", "Saturday: 16-26 Sunny")


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed_view_screen)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val thirdExitButton = findViewById<Button>(R.id.thirdExitButton)
        thirdExitButton.setOnClickListener {
            finish()
        }
        val displayTextView = findViewById<TextView>(R.id.displayTextView)

        var detailsDisplay = ""
        var counter = 0
        while (counter < days.size) {
            detailsDisplay += "${days[counter]}\n"

            counter++
            displayTextView.text = detailsDisplay


            }

        }

    }
