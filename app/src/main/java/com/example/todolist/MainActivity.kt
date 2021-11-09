package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var todoAdapter : TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        todoAdapter = TodoAdapter(mutableListOf())

        RecyclerViewTodoItems.adapter = todoAdapter
        RecyclerViewTodoItems.layoutManager = LinearLayoutManager(this)

        BtnAddTodo.setOnClickListener {
            val todoTitle = EditTextTodoTitle.text.toString()
            if (todoTitle.isNotEmpty()) {
                val todo = Todo(todoTitle)
                todoAdapter.addTodo(todo)
                EditTextTodoTitle.text.clear()
            }
        }
        BtnDelTodo.setOnClickListener {
            todoAdapter.deleteDoneTodos()
        }
    }
}