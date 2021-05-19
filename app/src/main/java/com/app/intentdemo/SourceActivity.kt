package com.app.intentdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

private const val TAG = "SourceActivity"

class SourceActivity : AppCompatActivity() {

    lateinit var nameEditText: EditText
    lateinit var ageEditText: EditText
    lateinit var sendBtn: Button
    lateinit var sendOutSideBtn: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameEditText = findViewById(R.id.et_name)
        ageEditText = findViewById(R.id.et_age)
        sendBtn = findViewById(R.id.btn_send)
        sendOutSideBtn = findViewById(R.id.btn_send_outside)

        sendBtn.setOnClickListener { sendData() }

        sendOutSideBtn.setOnClickListener{ sendDataOutside() }

    }

    private fun sendData() {
        val intent = Intent(this, DestinationActivity::class.java)
        intent.putExtra("name", nameEditText.text?.toString())
        intent.putExtra("age", Integer.parseInt(ageEditText.text.toString()))

        Log.d(TAG, "name is ${nameEditText.text}")
        Log.d(TAG, "age is ${ageEditText.text}")

        startActivity(intent)
    }

    private fun sendDataOutside() {

        val name = nameEditText.text.toString()
        val age = ageEditText.text.toString()

        var info = "$name $age"

        val sendIntent: Intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, info)
            type = "text/plain"
        }

        val shareIntent = Intent.createChooser(sendIntent, null)

        startActivity(shareIntent)
    }
}