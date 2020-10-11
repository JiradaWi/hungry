package com.example.hungry

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.protein.*
import kotlin.random.Random

class chooseProteinActivity: AppCompatActivity() {
    var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.protein)
        //textView2.setOnclick
        randomFood.setOnClickListener{
            count++
            var food = "";
            if(count > 7){
                count = 0
                food = "JUST ORDER SOME FOOD, PLEASE."
                foodMenu.setTextColor(Color.parseColor("#FF0000"));
            }else {
                val rnds = (0..5).random()

                val builder = StringBuilder()
                if (rnds == 1) {
                    builder.append(rnds)
                        .append(" Pork")
                } else if (rnds == 2) {
                    builder.append(rnds)
                        .append(" Chicken")
                } else if (rnds == 3) {
                    builder.append(rnds)
                        .append(" Beef")
                } else if (rnds == 4) {
                    builder.append(rnds)
                        .append(" Squid")
                } else if (rnds == 5) {
                    builder.append(rnds)
                        .append(" Canned Tuna")
                } else {
                    builder.append(rnds)
                        .append(" No food for you!")
                }
                food = builder.toString()
                foodMenu.setTextColor(Color.parseColor("#000000"));
            }

            foodMenu.text = food
        }

    }
}