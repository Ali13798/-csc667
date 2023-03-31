package com.example.geoquiz

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
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

        binding.btnCheat.setOnClickListener {
            val answerIsTrue = quizViewModel.currentQuestionAnswer
            val intent = CheatActivity.newIntent(this@MainActivity, answerIsTrue)
            cheatLauncher.launch(intent)
        }
    }

    private val cheatLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            quizViewModel.isCheater =
                result.data?.getBooleanExtra(EXTRA_ANSWER_SHOWN, false) ?: false
        }
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = quizViewModel.currentQuestionAnswer
        val msg = when {
            quizViewModel.isCheater -> R.string.tst_judge
            userAnswer == correctAnswer -> R.string.tst_correct
            else -> R.string.tst_false
        }
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    private fun updateQuestion() {
        val questionTextResId = quizViewModel.currentQuestionText
        binding.tvQuestion.setText(questionTextResId)
    }
}