package com.example.hungry

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.protein.*
import kotlin.random.Random

class chooseProteinActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.protein)
        //textView2.setOnclick
        protein.setOnClickListener{
            val rnds = (0..5).random()
            var food = "";
            val builder = StringBuilder()
            if(rnds == 1){
                builder.append(rnds)
                    .append(" Pizza")
            }else if(rnds == 2){
                builder.append(rnds)
                    .append(" Sushi")
            }else if(rnds == 3){
                builder.append(rnds)
                    .append(" Somtum")
            }else if(rnds == 4){
                builder.append(rnds)
                    .append(" Samosa")
            }else if(rnds == 5){
                builder.append(rnds)
                    .append(" Fried Chicken")
            }else{
                builder.append(rnds)
                    .append(" No food")
            }
            food = builder.toString()


            foodMenu.text = food
        }

    }
}