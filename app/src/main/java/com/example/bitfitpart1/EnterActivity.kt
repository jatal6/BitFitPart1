package com.example.bitfitpart1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class EnterActivity : AppCompatActivity() {

    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter)

        button = findViewById(R.id.addButton)
        button.setOnClickListener {

            val itemName = findViewById<EditText>(R.id.itemNameEditText).text.toString()
            val sets = findViewById<EditText>(R.id.SetsEditText).text.toString()
            val newItem = Item(itemName, sets)
            Toast.makeText(it.context, "Exercise Entered", Toast.LENGTH_SHORT).show()


            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("Result", newItem)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

    }

}