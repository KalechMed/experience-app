package com.example.testtt

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class Add_Experience : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_experience)
        val sharedPref = getSharedPreferences("localdata", Context.MODE_PRIVATE)
        val editText1 = findViewById<TextInputEditText>(R.id.text1)
        val editText2 = findViewById<TextInputEditText>(R.id.text2)
        val editText3 = findViewById<TextInputEditText>(R.id.text3)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val text1 = editText1.text.toString()
            val text2 = editText2.text.toString()
            val text3 = editText3.text.toString()


            val editor = sharedPref.edit()
            editor.putString("name", text1)
            editor.putString("address", text2)
            editor.putString("num", text3)
            editor.apply()


            /*
            delete shaared pref

            val sharedPref = getSharedPreferences("localdata", Context.MODE_PRIVATE)
val editor = sharedPref.edit()

// Clear all values
editor.clear()

// Apply the changes
editor.apply()

            */


            val intent = Intent(this@Add_Experience, ListActivity::class.java)
            startActivity(intent)



            Toast.makeText(this, "Name: $text1\naddress: $text2\nnum: $text3", Toast.LENGTH_SHORT).show()
        }

    }


}