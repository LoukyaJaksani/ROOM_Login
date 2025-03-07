package com.loukya.loginusingroom

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import org.w3c.dom.Text

class RegisterActivity : AppCompatActivity() {

    private lateinit var  viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)

        supportActionBar?.apply {
            title = "Register Activity"
            elevation= 2f
        }

        viewModel = ViewModelProvider(this)[UserViewModel::class.java]

        val nameEt = findViewById<EditText>(R.id.name_et)
        val emailEt = findViewById<EditText>(R.id.email_et)
        val passwordEt = findViewById<EditText>(R.id.password_et)
        val registerBtn = findViewById<Button>(R.id.login_btn)

        registerBtn.setOnClickListener {
            val name = nameEt.text.toString()
            val email = emailEt.text.toString()
            val password = passwordEt.text.toString()

            if(name.isEmpty()||email.isEmpty()||password.isEmpty()){
                Toast.makeText(this,"User Registered!",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val user = User(name = name, email = email, password = password)
            viewModel.insertUser(user)
            Toast.makeText(this, "User Registered", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }


    }
}