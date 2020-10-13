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

    var endNumber = 100
    var currentOperation = 0

    val operationMaster = mapOf("0" to "+", "1" to "-")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.math_game)

        startbutton.setOnClickListener{
            startbutton.visibility = View.INVISIBLE

            scorelabel.visibility = View.VISIBLE;

            score.text = currentscore.toString()
            score.visibility = View.VISIBLE

            answerBox.visibility = View.VISIBLE

            generateNewQuestion()
        }

        answerBox.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            val answer = answerBox.text
            var correctanswer = 0
          //  println("answer: "+answer.toString().toIntOrNull())
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                if(getCurrentOperation(currentOperation) == "+"){
                    correctanswer = firstnum + secondnum
                }else if(getCurrentOperation(currentOperation) == "-"){
                    correctanswer = firstnum - secondnum
                }else{
                    println("Operation not supported.")
                }
                if(correctanswer == answer.toString().toIntOrNull()){
                    currentscore++
                    generateNewQuestion()
                } else{
                    currentscore--
                }
                score.text = currentscore.toString()
                answerBox.text = null
            }
            false
        })
    }

    fun generateNewQuestion() {
        if(currentscore > 3){
            endNumber = 1000
        }
        firstnum  = (0..endNumber).random()
        secondnum  = (0..endNumber).random()

        currentOperation = (0..1).random()

        val questionbuilder = StringBuilder()
        if(firstnum >=  secondnum){
            questionbuilder.append(firstnum).append( getCurrentOperation(currentOperation) ).append(secondnum)
        }else{
            questionbuilder.append(secondnum).append( getCurrentOperation(currentOperation) ).append(firstnum)
            firstnum = secondnum.also { secondnum = firstnum }
        }

        question.text = questionbuilder.toString()
        question.visibility = View.VISIBLE

    }

    fun getCurrentOperation(oprtn: Int): String{
        return operationMaster.get(oprtn.toString()).toString()
    }
}