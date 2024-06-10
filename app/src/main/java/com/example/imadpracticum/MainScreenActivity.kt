package com.example.imadpracticum

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainScreenActivity : AppCompatActivity() {

    val days = arrayOf<String>(
        "Sunday",
        "Monday",
        "Tuesday",
        "Wednesday",
        "Thursday",
        "Friday",
        "Saturday"
    )
    val temperature = arrayOf<Int>(20, 21, 22, 23, 24, 25, 26)
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_screen)

        val detailedViewButton = findViewById<android.widget.Button>(R.id.detailedViewButton)
        detailedViewButton.setOnClickListener {
            val intent = Intent(this, DetailedViewScreen::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val secondExitButton = findViewById<Button>(R.id.secondExitButton)
        secondExitButton.setOnClickListener {
            finish()


        }

        val inputEditText = findViewById<TextView>(R.id.inputEditText)
        val resultTextView = findViewById<TextView>(R.id.resultTextView)
        val getTempButton = findViewById<Button>(R.id.getTempButton)
        getTempButton.setOnClickListener {
            val input = inputEditText.text.toString()
            val dayIndex = days.indexOf(input)
            if (dayIndex != -1) {
                resultTextView.text = "Temperature on ${days[dayIndex]} is ${temperature[dayIndex]}°C"
            } else {
                resultTextView.text = "Invalid input, Please use capital letters"
            }
        }
        val averageTempTextView = findViewById<TextView>(R.id.averageTempTextView)
        val getAverageButton = findViewById<Button>(R.id.getAverageButton)
        getAverageButton.setOnClickListener {
            val sum = temperature.sum()
            val average = sum / temperature.size
            averageTempTextView.text = "Average temperature this week is $average°C"
        }
        val clearButton = findViewById<Button>(R.id.clearButton)
        clearButton.setOnClickListener {
            inputEditText.text = ""
            resultTextView.text = ""
            averageTempTextView.text = ""


        }

    }

}



