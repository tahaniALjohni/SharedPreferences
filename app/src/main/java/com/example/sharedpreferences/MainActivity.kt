package com.example.sharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var etEntry1: EditText
    private lateinit var etEntry2: EditText
    private lateinit var myIntent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etEntry1= findViewById(R.id.entry1)
        etEntry2= findViewById(R.id.entry2)
        sharedPreferences = this.getSharedPreferences(
            getString(R.string.preference_file_key), Context.MODE_PRIVATE
        )
        myIntent= Intent(this,SecondActivity::class.java)
    }

    fun saveData(view: View) {
        if (etEntry1.text.isNotBlank()&& etEntry2.text.isNotBlank()){
            with(sharedPreferences.edit()) {
                putString("xx1", etEntry1.text.toString())
                putString("xx2", etEntry2.text.toString())
                apply()
            }
        }
        startActivity(myIntent)
    }
    fun sendData(view: View) {
        if (etEntry1.text.isNotBlank()&& etEntry2.text.isNotBlank()){
            myIntent.putExtra("x1",etEntry1.text.toString())
            myIntent.putExtra("x2",etEntry2.text.toString())
        }
    }
}