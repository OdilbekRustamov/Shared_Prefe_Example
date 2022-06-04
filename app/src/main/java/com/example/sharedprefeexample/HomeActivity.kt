package com.example.sharedprefeexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class HomeActivity : AppCompatActivity() {
    lateinit var btn_save: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        initViews()
    }

    private fun initViews() {
        btn_save = findViewById(R.id.btn_save)
        btn_save.setOnClickListener {
            SharePref(this).isSaved = true
        }
    }
}