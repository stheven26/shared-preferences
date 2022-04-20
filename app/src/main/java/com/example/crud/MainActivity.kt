package com.example.crud

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences
    var isRemembered = false

    lateinit var txtName: EditText
    lateinit var txtAge: EditText
    lateinit var btnRegister: Button
    lateinit var checkBox: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()

        sharedPreferences = getSharedPreferences("Shared_Preferences", Context.MODE_PRIVATE)
        isRemembered = sharedPreferences.getBoolean("CheckBox", false)

        if(isRemembered){
            val intent = Intent(this, AnotherActivity::class.java)
            startActivity(intent)
            finish()
        }

        btnRegister.setOnClickListener {
            val Name: String = txtName.text.toString()
            val Age: Int = txtAge.text.toString().toInt()
            val checked: Boolean = checkBox.isChecked
            val editor: SharedPreferences.Editor = sharedPreferences.edit()

            editor.putString("Name", Name)
            editor.putInt("Age", Age)
            editor.putBoolean("CheckBox", checked)
            editor.apply()
            Toast.makeText(this, "Information Saved!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, AnotherActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun init(){
        txtName = findViewById(R.id.Name)
        txtAge = findViewById(R.id.Age)
        checkBox = findViewById(R.id.checkbox)
        btnRegister = findViewById(R.id.save)
    }
}