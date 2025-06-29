package com.example.bikers_zone

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentContainer

class MainActivity : AppCompatActivity() {
    private lateinit var signInTextBtn:TextView
    private lateinit var signUpTextBtn:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        signInTextBtn = findViewById(R.id.signInTV)
        signUpTextBtn = findViewById(R.id.signUpTV)

        supportFragmentManager.beginTransaction().replace(R.id.container,LoginActivity()).commit()

        signInTextBtn.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.container,LoginActivity()).commit()
        }
        signUpTextBtn.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.container,SignupActivity()).commit()
        }

    }
}