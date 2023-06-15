package com.example.testtt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout

class YourResume : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_your_resume)

        val buttonResume: Button = findViewById(R.id.button4)
        val buttonLanguage: Button = findViewById(R.id.Btn_Language)
        val buttonHobbies: Button = findViewById(R.id.Btn_Hobbies)
        val fragmentContainer: FrameLayout = findViewById(R.id.fragmentC)


        buttonLanguage.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentC, language())
                .commit()
        }

        buttonHobbies.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentC, hobbies())
                .commit()
        }
        buttonResume.setOnClickListener {
            val intent = Intent(this@YourResume, Add_Experience::class.java)
            startActivity(intent)
        }
    }
}