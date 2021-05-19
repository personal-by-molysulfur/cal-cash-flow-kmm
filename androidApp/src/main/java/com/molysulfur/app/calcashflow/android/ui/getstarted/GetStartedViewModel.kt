package com.molysulfur.app.calcashflow.android.ui.getstarted

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GetStartedViewModel @Inject constructor() : ViewModel() {


    fun getGeeting() {
        Log.e("TAG", "Geeting")
    }
}