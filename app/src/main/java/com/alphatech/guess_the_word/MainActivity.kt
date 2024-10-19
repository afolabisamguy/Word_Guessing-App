package com.alphatech.guess_the_word

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import java.util.Arrays
import java.util.Collections
import java.util.Random

class MainActivity : ComponentActivity() {

    // Declaring Array of String

    internal var Days = arrayOf(
        "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
    )

    // Declaring all other variables
    lateinit var day: String
    lateinit var random: Random

    // Declaring variable for the views
    lateinit var txtRightAnswer: TextView
    lateinit var txtQuestionContainer: TextView
    lateinit var txtCorrectAnswer: TextView
    lateinit var etUserInput: EditText
    lateinit var btShow : Button
    lateinit var btCheck : Button
    lateinit var btNext : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtRightAnswer = findViewById(R.id.txtRightAnswer)
        txtCorrectAnswer = findViewById(R.id.txtCorrectAnswer)
        txtQuestionContainer = findViewById(R.id.txtQuestionContainer)

        etUserInput = findViewById(R.id.etUser_Input)

        btShow = findViewById(R.id.btShow)
        btNext = findViewById(R.id.btNext)
        btCheck = findViewById(R.id.btCheck)

        // initialize the random variable
        random = Random()

        // Actual Logic
        day = Days[random.nextInt(Days.size)]
        txtQuestionContainer.text = mixWords(day)

        // set the listener to the check Button
        btCheck.setOnClickListener{
            if (etUserInput.text.toString().equals(day, ignoreCase = true)){
                val dialog = Dialog(this@MainActivity)
                dialog.setContentView(R.layout.correct_dialog)
                val bthide = dialog.findViewById<Button>(R.id.btConfirmDialog)
                dialog.show()

                bthide.setOnClickListener{
                    dialog.dismiss()
                    // Next Question
                    day = Days[random.nextInt(Days.size)]
                    txtQuestionContainer.text = mixWords(day)
                    // make the correct answer invisible
                    txtCorrectAnswer.visibility = View.INVISIBLE
                    txtRightAnswer.visibility = View.INVISIBLE
                    // Clear user input
                    etUserInput.setText("")

                }
            }
            else{
                Toast.makeText(this@MainActivity, "You're Wrong...", Toast.LENGTH_SHORT).show()
            }
        }

        btNext.setOnClickListener{
            day = Days[random.nextInt(Days.size)]
            txtQuestionContainer.text = mixWords(day)
            txtRightAnswer.visibility = View.INVISIBLE
            txtCorrectAnswer.visibility = View.INVISIBLE
            etUserInput.setText("")
        }

        btShow.setOnClickListener{
            txtCorrectAnswer.visibility = View.VISIBLE
            txtRightAnswer.visibility = View.VISIBLE
            txtRightAnswer.text = day
        }

    }


    fun mixWords(word: String) : String {
        val word = Arrays.asList<String>(*word.split("".toRegex()).dropLastWhile({it.isEmpty()}).toTypedArray())

        // Still dont know what this is doing but i think it shuffles the words and assign it
        // through a for loop to the variable mixed

        Collections.shuffle(word)
        var mixed = ""
        for (i in word){
            mixed += i
        }
        return mixed
    }
}