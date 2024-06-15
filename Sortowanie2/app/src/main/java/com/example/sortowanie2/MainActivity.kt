package com.example.sortowanie2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicjalizacja ViewModel
        ViewModelProvider(this)[SharedViewModel::class.java]
        
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView2, WejscieFragment())
            .commit()

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, WyjscieFragment())
            .commit()
    }

}