package com.example.geoquiz

import androidx.lifecycle.ViewModel

class QuizViewModel : ViewModel() {
    private var currentIndex = 0
    private val questionBank = listOf(
        Question(R.string.q_australia, true),
        Question(R.string.q_germany, true),
        Question(R.string.q_iran, true),
        Question(R.string.q_us, false),
    )
    val currentQuestionAnswer: Boolean
        get() = questionBank[currentIndex].answer
    val currentQuestionText: Int
        get() = questionBank[currentIndex].textResId

    fun moveToNext() {
        currentIndex = (currentIndex + 1) % questionBank.size
    }

    fun moveToPrev() {
        val n = questionBank.size
        currentIndex = (currentIndex + n - 1) % n
    }
}