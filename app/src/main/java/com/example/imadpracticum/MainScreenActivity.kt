package com.example.imadpracticum

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainScreenActivity : AppCompatActivity() {

    val days = arrayOf<String>("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")
    val temperature = arrayOf<Int>(20, 21, 22, 23, 24, 25, 26)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_screen)

        val detailedViewButton = findViewById<android.widget.Button>(R.id.detailedViewButton)
        detailedViewButton.setOnClickListener {
            val intent = Intent(this,DetailedViewScreen::class.java)
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


    }
}