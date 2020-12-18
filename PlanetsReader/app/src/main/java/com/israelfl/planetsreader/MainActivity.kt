package com.israelfl.planetsreader

import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        contentResolver.query(
            Uri.parse("content://com.israelfl.planets.PlanetProvider"),
            arrayOf("planets"),
            null,
            null,
            null
        )?.apply {
            if (moveToFirst()) {
                do {
                    val planets = getString(0)
                    findViewById<TextView>(R.id.tv_json).apply {
                        text = planets
                    }
                } while (moveToNext())
            }
            close()
        }
    }
}
