package com.example.intentsdemo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    private lateinit var tvResult: TextView

    private val getResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val data = result.data?.getStringExtra("finalResult")
                tvResult.text = "Result: $data"
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val tvReceived = findViewById<TextView>(R.id.tvReceived)
        val btnSendResult = findViewById<Button>(R.id.btnSendResult)
        tvResult = findViewById(R.id.tvResult)

        val receivedText = intent.getStringExtra("userText")
        tvReceived.text = "Received: $receivedText"

        btnSendResult.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)
            getResult.launch(intent)
        }
    }
}
