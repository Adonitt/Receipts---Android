package com.example.project1.activities

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.project1.R

class MainActivity : ComponentActivity() {
    private lateinit var username: EditText
    private lateinit var password: EditText
    private lateinit var loginBtn: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_page)

        username = findViewById(R.id.username)
        password = findViewById(R.id.password)
        loginBtn = findViewById(R.id.login_button)

        loginBtn.setOnClickListener {
            if (username.text.toString().isBlank() || password.text.toString().isBlank()) {
                Toast.makeText(this, "Please enter your credentials!", Toast.LENGTH_LONG).show()
            } else if (!validatePassword(password.text.toString())) {
                Toast.makeText(
                    this,
                    "First letter of password should be uppercase and the length should be 8 or more!",
                    Toast.LENGTH_LONG
                ).show()
            } else if (username.text.toString() != "admin" && password.text.toString() != "Admin123.") {
                Toast.makeText(this, "Username or password is incorrect!", Toast.LENGTH_LONG).show()

            } else if (username.text.toString() == "admin" && password.text.toString() == "Admin123.") {
                Toast.makeText(this, "Logged in successfully!", Toast.LENGTH_LONG).show()
                val intent = Intent(this, ListActivity::class.java)
                startActivity(intent)
            }
        }
    }


    fun validatePassword(input: String) = input.length >= 8 && input[0].isUpperCase()

}
