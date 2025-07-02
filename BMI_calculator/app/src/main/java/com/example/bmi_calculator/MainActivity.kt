package com.example.bmi_calculator

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import com.example.bmi_calculator.databinding.ActivityMainBinding
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calculateBTn.setOnClickListener {
            CalculateBmi()
        }


    }

    private fun CalculateBmi() {
        val weightStr = binding.weightET.text.toString()
        val heightStr = binding.heightET.text.toString()

        if (weightStr.isEmpty()) {
            binding.weightET.error = "Enter Weight"
        } else if (heightStr.isEmpty()) {
            binding.heightET.error = "Enter Height"
        } else {
            val weight = weightStr.toDouble()
            val height = heightStr.toDouble() / 100

            val result = weight / (height.pow(2))
            val formattedResult = String.format("%.2f", result)

            binding.resultTV.text = formattedResult

            val maleBtnClicked = binding.male.isChecked
            val femaleBtnClicked = binding.female.isChecked

            if (maleBtnClicked) {
                binding.normalRangeTV.text = "Normal Range For Male : 18.5- 24.9"
            } else {
                binding.normalRangeTV.text = "Normal Range For Female : 18.5- 24.9"
            }

            binding.resultCardView.isVisible = true
            binding.resultCardView.setBackgroundResource(R.drawable.custom_card)

            when {
                result < 18.5 -> {
                    binding.resultTypeTV.text = "Underweight"
                    binding.resultTV.setTextColor(ContextCompat.getColor(this, R.color.underweight))
                    binding.resultTypeTV.setTextColor(
                        ContextCompat.getColor(
                            this,
                            R.color.underweight
                        )
                    )
                    binding.normalRangeTV.setTextColor(
                        ContextCompat.getColor(
                            this,
                            R.color.underweight
                        )
                    )
                }

                result >= 18.5 && result <= 24.9 -> {
                    binding.resultTypeTV.text = "Healthy"
                    binding.resultTV.setTextColor(ContextCompat.getColor(this, R.color.healthy))
                    binding.resultTypeTV.setTextColor(ContextCompat.getColor(this, R.color.healthy))
                    binding.normalRangeTV.setTextColor(
                        ContextCompat.getColor(
                            this,
                            R.color.healthy
                        )
                    )
                }

                result >= 25.0 && result <= 29.9 -> {
                    binding.resultTypeTV.text = "Overweight"
                    binding.resultTV.setTextColor(ContextCompat.getColor(this, R.color.overweight))
                    binding.resultTypeTV.setTextColor(
                        ContextCompat.getColor(
                            this,
                            R.color.overweight
                        )
                    )
                    binding.normalRangeTV.setTextColor(
                        ContextCompat.getColor(
                            this,
                            R.color.overweight
                        )
                    )
                }

                result >= 30.0 -> {
                    binding.resultTypeTV.text = "Obese"
                    binding.resultTV.setTextColor(ContextCompat.getColor(this, R.color.obese))
                    binding.resultTypeTV.setTextColor(ContextCompat.getColor(this, R.color.obese))
                    binding.normalRangeTV.setTextColor(ContextCompat.getColor(this, R.color.obese))
                }

                else -> {
                    binding.resultTV.text = "0"
                    binding.resultTypeTV.text = "Error"
                }
            }
        }


    }
}