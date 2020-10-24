package com.example.hungry

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        yesButton.setOnClickListener{
//            startActivity(Intent(this, chooseProteinActivity::class.java))
//        }

        playMath.setOnClickListener{
           startActivity(Intent(this, playMathActivity::class.java))
        }
    }

}