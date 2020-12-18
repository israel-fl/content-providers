package com.israelfl.planets

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.israelfl.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val text = resources.openRawResource(R.raw.planets).bufferedReader().use { it.readText() }
        val tvJson = findViewById<TextView>(R.id.tv_json)
        tvJson.text = text
    }
}
