package com.example.geoquiz

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.geoquiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val quizViewModel: QuizViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        updateQuestion()

        binding.btnTrue.setOnClickListener {
            checkAnswer(true)
        }
        binding.btnFalse.setOnClickListener {
            checkAnswer(false)
        }

        binding.btnNext.setOnClickListener {
            quizViewModel.moveToNext()
            updateQuestion()
        }
        binding.btnPrev.setOnClickListener {
            quizViewModel.moveToPrev()
            updateQuestion()
        }
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = quizViewModel.currentQuestionAnswer
        val msg = if (userAnswer == correctAnswer) R.string.tst_correct else R.string.tst_false
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    private fun updateQuestion() {
        val questionTextResId = quizViewModel.currentQuestionText
        binding.tvQuestion.setText(questionTextResId)
    }
}