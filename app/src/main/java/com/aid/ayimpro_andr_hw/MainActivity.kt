package com.aid.ayimpro_andr_hw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {

    private lateinit var txtCount: TextView
    private lateinit var btnCount: AppCompatButton
    private lateinit var KEY_COUNT: String
    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtCount = findViewById(R.id.txt1)
        btnCount = findViewById(R.id.btn1)
        val btnReset = findViewById<AppCompatButton>(R.id.btn2)

        btnCount.setOnClickListener {
            onClick(it)
        }

        btnReset.setOnClickListener {
            onClick(it)
        }

        if (savedInstanceState != null) {
            count = savedInstanceState.getInt(KEY_COUNT, 0)
        }
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt(KEY_COUNT, count)
    }

    private fun onClick(v: View) {
        when (v.id) {
            R.id.btn1 -> {
                count++
                txtCount.text = count.toString()
            }
            R.id.btn2 -> {
                count = 0
                txtCount.text = count.toString()
            }
        }
    }

}