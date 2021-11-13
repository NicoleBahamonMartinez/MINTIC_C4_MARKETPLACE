package com.example.corazonsaludable.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.corazonsaludable.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val iniciarsesion = findViewById<Button>(R.id.buttonIniciarSesion)
        val registro = findViewById<Button>(R.id.buttonCrearCuenta)
        val intentIniciarSesion = Intent(this,LoginActivity::class.java)
        val intentRegistrarse = Intent(this,RegisterActivity::class.java)
        iniciarsesion.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                startActivity(intentIniciarSesion);
            }
        })
        registro.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
                startActivity(intentRegistrarse)
            }
        })

    }
    }