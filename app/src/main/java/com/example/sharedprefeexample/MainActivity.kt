package com.example.sharedprefeexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.asLiveData
import com.example.sharedprefeexample.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var appPref: AppPref
    var age = 0
    var name = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        appPref = AppPref(this)

        buttonSave()
        observeData()
    }

    private fun observeData() {
        appPref.userName.asLiveData().observe(this, {
            name = it
            binding.tvName.text = it
        })

        appPref.userAge.asLiveData().observe(this, {
            age = it
            binding.tvAge.text = it.toString()
        })
    }

    private fun buttonSave() {
        binding.apply {
            btnSave.setOnClickListener {
                name = etName.text.toString()
                age = etAge.text.toString().toInt()

                GlobalScope.launch {
                    appPref.storeUser(age, name)
                }
            }
        }
    }
}