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

        binding.btnTrue.setOnClickListener {
            checkAnswer(true)
        }
        binding.btnFalse.setOnClickListener {
            checkAnswer(false)
        }

        binding.btnNext.setOnClickListener {
            currentIndex = (currentIndex + 1) % questionBank.size
            val questionTextResId = questionBank[currentIndex].textResId
            binding.tvQuestion.setText(questionTextResId)
        }
        binding.btnPrev.setOnClickListener {
            val n = questionBank.size
            currentIndex = (currentIndex + n - 1) % n
            val questionTextResId = questionBank[currentIndex].textResId
            binding.tvQuestion.setText(questionTextResId)
        }

        val questionTextResId = questionBank[currentIndex].textResId
        binding.tvQuestion.setText(questionTextResId)
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = questionBank[currentIndex].answer
        val msg = if(userAnswer == correctAnswer) R.string.tst_correct else R.string.tst_false
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}