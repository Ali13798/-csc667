package com.example.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var trueButton: Button
    private lateinit var falseButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)

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

    }
}