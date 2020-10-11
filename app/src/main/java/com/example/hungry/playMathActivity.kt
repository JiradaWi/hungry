package com.example.hungry

import android.content.res.Configuration
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.math_game.*

class playMathActivity: AppCompatActivity() {
    var firstnum = 0
    var secondnum = 0

    var currentscore = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.math_game)

        startbutton.setOnClickListener{
            startbutton.visibility = View.INVISIBLE

            scorelabel.visibility = View.VISIBLE;
            score.visibility = View.VISIBLE
            answerBox.visibility = View.VISIBLE

            generateNewQuestion()
        }

        answerBox.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            val answer = answerBox.text
          //  println("answer: "+answer.toString().toIntOrNull())
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {

                if(firstnum + secondnum == answer.toString().toIntOrNull()){
                    currentscore++
                    generateNewQuestion()
                } else{
                    currentscore--
                }
                score.text = currentscore.toString()
            }
            false
        })
    }

    fun generateNewQuestion() {
        firstnum  = (0..100).random()
        secondnum  = (0..100).random()

        val questionbuilder = StringBuilder()
        questionbuilder.append(firstnum).append(" + ").append(secondnum)
        // val question = questionbuilder.toString()

        question.text = questionbuilder.toString()
        question.visibility = View.VISIBLE

    }
}