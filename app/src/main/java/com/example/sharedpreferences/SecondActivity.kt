package com.example.sharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Context
import android.content.SharedPreferences
import android.view.View
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var tvFirst: TextView
    private lateinit var tvSecond: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        tvFirst= findViewById(R.id.tvFirst)
        tvSecond= findViewById(R.id.tvSecond)
        sharedPreferences = this.getSharedPreferences(
            getString(R.string.preference_file_key), Context.MODE_PRIVATE
        )
        tvFirst.text = intent.extras?.getString("one").toString()
        tvSecond.text= intent.extras?.getString("two").toString()
    }

    fun callData(view: View) {
        tvFirst.text = sharedPreferences.getString("One","")
        tvSecond.text= sharedPreferences.getString("Two","")
    }
    }