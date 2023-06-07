package com.example.poeprojecttest1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        data class User(val username: String, val password: String)


        var btnLogin = findViewById<Button>(R.id.btnLogin)
        var btnRegister = findViewById<Button>(R.id.btnRegister)
        var headingtxt3 = findViewById<TextView>(R.id.headingtxt3)
        var headingtxt4 = findViewById<TextView>(R.id.headingtxt4)
        var RUNtxt = findViewById<EditText>(R.id.RUNtxt)
        var RPWtxt = findViewById<EditText>(R.id.RPWtxt)
        var LUNtxt = findViewById<EditText>(R.id.LUNtxt)
        var LPWtxt = findViewById<EditText>(R.id.LPWtxt)
        val registeredUsers = mutableListOf<User>()

        val un = "admin"
        val pw = "admin123"
        val newUser = User(un, pw)
        registeredUsers.add(newUser)


        btnLogin.setOnClickListener(){
            if(LUNtxt.text.isNotEmpty() && LPWtxt.text.isNotEmpty())
            {
                val username = LUNtxt.text.toString()
                val password = LPWtxt.text.toString()
                val matchedUser = registeredUsers.find { it.username == username && it.password == password }

                if (matchedUser != null) {
                    val intent = Intent(this@MainActivity, HomePage::class.java)
                    startActivity(intent)
                } else {
                    headingtxt3.text = "Invalid User"
                }
            }
            else
            {
                headingtxt3.text = "All fields are required to register"
            }

        }

        btnRegister.setOnClickListener(){
            if(RUNtxt.text.isEmpty() || RPWtxt.text.isEmpty())
            {
                headingtxt4.text = "All fields are required to register"
            }
            else
            {
                val username = RUNtxt.text.toString()
                val password = RPWtxt.text.toString()
                val newUser = User(username, password)
                registeredUsers.add(newUser)
                headingtxt4.text = "Registration Complete"
            }

        }
    }
}