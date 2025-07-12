package com.example.counter_app_mvvm

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.counter_app_mvvm.databinding.ActivityMainBinding
import com.example.counter_app_mvvm.viewmodel.CounterViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: CounterViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(CounterViewModel::class.java)

        binding.counterTV.text = viewModel.getInitialCount().toString()
        binding.counterBTN.setOnClickListener {
            binding.counterTV.text = viewModel.getUpdatedCount().toString()
        }

    }
}