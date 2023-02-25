package com.example.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.geoquiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

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

    }
}