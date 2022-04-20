package com.example.crud

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class AnotherActivity : AppCompatActivity() {
    lateinit var preferences: SharedPreferences
    lateinit var name: TextView
    lateinit var age: TextView
    lateinit var clear: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_another)
        init()
        preferences = getSharedPreferences("Shared_Preferences", Context.MODE_PRIVATE)

        val nameLocal = preferences.getString("Name", " ")
        val ageLocal = preferences.getInt("Age", 0)
        name.text = "Nama Saya: ${nameLocal}"
        age.text = "Umur Saya: ${ageLocal}"

        clear.setOnClickListener{
            val editor: SharedPreferences.Editor = preferences.edit()
            editor.clear()
            editor.apply()
            Toast.makeText(this, "Data Clear!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
    private fun init(){
        name = findViewById(R.id.tv_name)
        age = findViewById(R.id.tv_age)
        clear = findViewById(R.id.clear)
    }
}