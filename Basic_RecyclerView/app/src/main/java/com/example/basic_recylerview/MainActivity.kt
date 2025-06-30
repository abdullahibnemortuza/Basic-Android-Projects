package com.example.basic_recylerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.basic_recylerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var todoList = mutableListOf(
            Todo("Home Work",true),
            Todo("Cycling For 1 Hour",false),
            Todo("Gaming For 30 min.",false),
            Todo("Programming 5 hour.",true),
            Todo("Design A Basic Application",true),
            Todo("Sleeping 3 hour.",false),
            Todo("Watching Movie.",false),
            Todo("Meeting Friends",false),
            Todo("Listening Songs",true),
            Todo("Have Dinner at 9.00 PM",false),
            Todo("Working with git",true),
            Todo("Ready For Sleep",false)
        )
        val adapter = TodoAdapter(todoList)
        binding.rvTodo.adapter = adapter
        binding.rvTodo.layoutManager = LinearLayoutManager(this)

        binding.addTodoBtn.setOnClickListener {
            val title = binding.etTodo.text.toString()
            val todo = Todo(title,false)
            todoList.add(todo)
            binding.etTodo.text = null
            adapter.notifyItemInserted(todoList.size - 1)
        }

    }
}