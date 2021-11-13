package com.example.corazonsaludable.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.corazonsaludable.R
import com.example.corazonsaludable.view.fragments.BeneficiosFragment
import com.example.corazonsaludable.view.fragments.HomeFragment
import com.example.corazonsaludable.view.fragments.PerfilFragment
import kotlinx.android.synthetic.main.activity_bottom_navigation.*


class BottomNavigationActivity : AppCompatActivity() {

    private val beneficiosFragment =  BeneficiosFragment()
    private val homeFragment = HomeFragment()
    private val perfilFragment = PerfilFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)
        replaceFragment(homeFragment)

        bottom_navigation.setOnNavigationItemReselectedListener {
            when(it.itemId){
             R.id.FirstFragment -> replaceFragment(homeFragment)
                R.id.SecondFragment -> replaceFragment(beneficiosFragment)
             R.id.ThirdFragment -> replaceFragment(perfilFragment)
            }
            true
        }
    }
    private fun replaceFragment(fragment: Fragment){
        if (fragment != null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frame_container,fragment)
            transaction.commit()
        }
    }


}