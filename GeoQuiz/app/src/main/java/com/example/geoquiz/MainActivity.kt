package com.example.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.geoquiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val questionBank = listOf(
        Question(R.string.q_australia, true),
        Question(R.string.q_germany, true),
        Question(R.string.q_iran, true),
        Question(R.string.q_us, false),
    )
    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        trueButton.setOnClickListener {
            val correctToast = Toast.makeText(this, R.string.correct_toast,Toast.LENGTH_SHORT)
            correctToast.setGravity(Gravity.TOP,0,250)
            correctToast.show()
        }
        falseButton.setOnClickListener {
            val falseToast = Toast.makeText(this, R.string.false_toast,Toast.LENGTH_SHORT)
            falseToast.setGravity(Gravity.TOP,0,250)
            falseToast.show()
        }

    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = questionBank[currentIndex].answer
        val msg = if(userAnswer == correctAnswer) R.string.tst_correct else R.string.tst_false
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}