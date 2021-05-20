package com.molysulfur.app.calcashflow.android.ui.getstarted

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GetStartedViewModel @Inject constructor() : ViewModel() {

    private val _submitSalary: MediatorLiveData<Float> = MediatorLiveData()
    val submitSalary get() = _submitSalary


    fun getSalarySubmit(salary: Float) {
        _submitSalary.postValue(salary)
    }
}