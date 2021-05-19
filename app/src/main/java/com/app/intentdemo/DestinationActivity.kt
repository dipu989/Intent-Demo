package com.app.intentdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

private const val TAG = "DestinationActivity"

class DestinationActivity : AppCompatActivity() {

    lateinit var nameTextView: TextView
    lateinit var ageTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_destination)

        nameTextView = findViewById(R.id.tv_placeholder_name)
        ageTextView = findViewById(R.id.tv_placeholder_age)

        val nameReceived = intent.getStringExtra("name")
        val ageReceived = intent.getIntExtra("age",0)

        nameTextView.text = nameReceived
        ageTextView.text = ageReceived.toString()

    }

}