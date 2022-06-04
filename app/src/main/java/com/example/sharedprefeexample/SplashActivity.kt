package com.example.sharedprefeexample

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        var handler = Handler()
        handler.postDelayed({
            if (SharePref(this).isSaved == true){
                Intent(this, MainActivity::class.java).also {
                    startActivity(it)
                }
            }else {
                Intent(this, HomeActivity::class.java).also {
                    startActivity(it)
                }
            }
        }, 2000)
    }
}