package com.molysulfur.app.calcashflow.android.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.molysulfur.app.calcashflow.android.R
import com.molysulfur.app.calcashflow.android.ui.getstarted.GetStartedActivity
import com.molysulfur.app.calcashflow.android.ui.main.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calcashflow_activity_splash)
        startActivity(Intent(this, GetStartedActivity::class.java))
    }
}