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
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val intentIniciarSesion = Intent(this,LoginActivity::class.java)
        findViewById<TextView>(R.id.textViewIniciaSesion).setOnClickListener(object : View.OnClickListener{
            override fun onClick(view: View?) {
                startActivity(intentIniciarSesion)
            }
        })

        findViewById<Button>(R.id.buttonRegistro).setOnClickListener{
            when{
                TextUtils.isEmpty(findViewById<EditText>(R.id.editTextEmailSignUp).text.toString().trim { it <= ' '}) ->{
                    Toast.makeText(
                        this@RegisterActivity,
                        "Por favor ingrese un correo electrónico",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                TextUtils.isEmpty(findViewById<EditText>(R.id.editTextPasswordSignUp).text.toString().trim { it <= ' '}) ->{
                    Toast.makeText(
                        this@RegisterActivity,
                        "Por favor ingrese una contraseña",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                !(TextUtils.equals(findViewById<EditText>(R.id.editTextEmailSignUp).text.toString().trim { it <= ' '},findViewById<EditText>(R.id.editTextVerificationEmailAddress).text.toString().trim { it <= ' '})) ->{
                    Toast.makeText(
                        this@RegisterActivity,
                        "El correo no coincide",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                else -> {
                    val email: String = findViewById<EditText>(R.id.editTextEmailSignUp).text.toString().trim { it <= ' '};
                    val password:String = findViewById<EditText>(R.id.editTextPasswordSignUp).text.toString().trim { it <= ' '}
                    FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password).addOnCompleteListener(
                        OnCompleteListener<AuthResult> { task ->
                            if(task.isSuccessful){
                                val FirebaseUser: FirebaseUser = task.result!!.user!!

                                Toast.makeText(
                                    this@RegisterActivity,
                                    "Registro exitoso!",
                                    Toast.LENGTH_SHORT
                                ).show()
                                val intent = Intent(this@RegisterActivity, user_info::class.java)
                                intent.flags=Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                startActivity(intent)
                                finish()
                            } else {
                                Toast.makeText(
                                    this@RegisterActivity,
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



