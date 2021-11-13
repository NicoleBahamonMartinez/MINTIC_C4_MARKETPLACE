package com.example.corazonsaludable.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.corazonsaludable.R

class user_info : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_info)

        val intentHome = Intent(this,BottomNavigationActivity::class.java)
        findViewById<TextView>(R.id.buttonGuardar).setOnClickListener(object : View.OnClickListener{
            override fun onClick(view: View?) {
                startActivity(intentHome)
            }
        })

    }
}