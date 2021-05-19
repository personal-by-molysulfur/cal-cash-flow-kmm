package com.molysulfur.app.calcashflow.android.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.molysulfur.app.calcashflow.Greeting
import com.molysulfur.app.calcashflow.android.R
import dagger.hilt.android.AndroidEntryPoint

fun greet(): String {
    return Greeting().greeting()
}

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
