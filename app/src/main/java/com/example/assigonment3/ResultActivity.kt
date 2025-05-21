package com.example.intentsdemo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val etResult = findViewById<EditText>(R.id.etResult)
        val btnReturn = findViewById<Button>(R.id.btnReturnResult)

        btnReturn.setOnClickListener {
            val resultText = etResult.text.toString()
            val resultIntent = Intent()
            resultIntent.putExtra("finalResult", resultText)
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}

