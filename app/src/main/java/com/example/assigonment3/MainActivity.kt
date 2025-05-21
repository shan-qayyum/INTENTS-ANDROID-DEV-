package com.example.intentsdemo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnGoToSecond = findViewById<Button>(R.id.btnGoToSecond)
        val btnOpenWeb = findViewById<Button>(R.id.btnOpenWeb)
        val btnShareText = findViewById<Button>(R.id.btnShareText)
        val userInput = findViewById<EditText>(R.id.userInput)

        btnGoToSecond.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("userText", userInput.text.toString())
            startActivity(intent)
        }

        btnOpenWeb.setOnClickListener {
            val webpage = Uri.parse("https://www.example.com")
            val intent = Intent(Intent.ACTION_VIEW, webpage)
            startActivity(intent)
        }

        btnShareText.setOnClickListener {
            val shareIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "Check out this cool Android app!")
                type = "text/plain"
            }
            startActivity(Intent.createChooser(shareIntent, "Share via"))
        }
    }
}
