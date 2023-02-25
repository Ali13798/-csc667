package com.example.geoquiz

import androidx.annotation.StringRes

class Question(
    @StringRes val textResId: Int,
    val answer: Boolean
) {
}