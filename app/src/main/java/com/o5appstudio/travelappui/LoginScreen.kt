package com.o5appstudio.travelappui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)

        val login : Button = findViewById(R.id.loginBtn)
        login.setOnClickListener {
            startActivity(Intent(this, MainDashboard::class.java))
            finish()
        }

    }
}