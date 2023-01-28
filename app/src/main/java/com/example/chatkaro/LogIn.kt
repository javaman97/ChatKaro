package com.example.chatkaro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LogIn : AppCompatActivity() {
    private  lateinit var etxtEmail: EditText
    private  lateinit var etxtPassword: EditText
    private  lateinit var btnLogin: Button
    private  lateinit var btnSignup: Button

    private lateinit var mAuth:FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        supportActionBar?.hide()
        mAuth=FirebaseAuth.getInstance()
        etxtEmail=findViewById(R.id.etxt_email)
        etxtPassword=findViewById(R.id.etxt_password)
        btnLogin=findViewById(R.id.btn_login)
        btnSignup=findViewById(R.id.btn_signup)

        btnSignup.setOnClickListener {
            val intent= Intent(this,SignUp::class.java)
            startActivity(intent)
        }

        btnLogin.setOnClickListener{

            val email=etxtEmail.text.toString();
            val password=etxtPassword.text.toString();

         login(email,password)

        }

    }
    private fun login(email:String,password:String) {

        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val intent = Intent(this@LogIn, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this@LogIn, "User does not exist", Toast.LENGTH_SHORT).show()
                }
            }
    }
    }