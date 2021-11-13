package com.example.corazonsaludable.view

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.corazonsaludable.R
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activiy_login)
        val intentRegistrate = Intent(this,RegisterActivity::class.java)
        findViewById<TextView>(R.id.textViewRegistrate).setOnClickListener(object : View.OnClickListener{
            override fun onClick(view: View?) {
                startActivity(intentRegistrate)
            }
        })
        findViewById<Button>(R.id.buttonInicioSesion).setOnClickListener{
            when{
                TextUtils.isEmpty(findViewById<EditText>(R.id.editTextEmailSignIn).text.toString().trim { it <= ' '}) ->{
                    Toast.makeText(
                        this@LoginActivity,
                        "Por favor ingrese un correo electrónico",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                TextUtils.isEmpty(findViewById<EditText>(R.id.editTextPasswordSignIn).text.toString().trim { it <= ' '}) ->{
                    Toast.makeText(
                        this@LoginActivity,
                        "Por favor ingrese una contraseña",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                else -> {
                    val email: String = findViewById<EditText>(R.id.editTextEmailSignIn).text.toString().trim { it <= ' '};
                    val password:String = findViewById<EditText>(R.id.editTextPasswordSignIn).text.toString().trim { it <= ' '}
                    FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password).addOnCompleteListener({ task ->
                            if(task.isSuccessful){
                                Toast.makeText(
                                    this@LoginActivity,
                                    "Inicio de sesión exitoso!",
                                    Toast.LENGTH_SHORT
                                ).show()
                                val intent = Intent(this@LoginActivity, BottomNavigationActivity::class.java)
                                startActivity(intent)
                                finish()
                            } else {
                                Toast.makeText(
                                    this@LoginActivity,
                                    task.exception!!.message.toString(),
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        })
                }


            }
        }
    }
}
