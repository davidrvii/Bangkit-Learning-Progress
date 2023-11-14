package com.example.myfavnba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class about : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        //untuk mengubah text pada title bar
        supportActionBar?.setTitle("About")
    }
}