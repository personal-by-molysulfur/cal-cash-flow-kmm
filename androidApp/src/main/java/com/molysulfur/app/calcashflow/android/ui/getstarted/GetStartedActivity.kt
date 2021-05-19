package com.molysulfur.app.calcashflow.android.ui.getstarted

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.molysulfur.app.calcashflow.android.R
import com.molysulfur.app.calcashflow.android.exception.InputNullOrBlankException
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.calcashflow_activity_getstarted.calcashflow_getstarted_button_submit as btnSubmit
import kotlinx.android.synthetic.main.calcashflow_activity_getstarted.calcashflow_getstarted_input_layout_salary as editSalary

@AndroidEntryPoint
class GetStartedActivity : AppCompatActivity() {
    private val viewModel: GetStartedViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calcashflow_activity_getstarted)
        btnSubmit.setOnClickListener {
            try {
                val text = editSalary.editText?.text
                if (text.isNullOrBlank()) {
                    throw InputNullOrBlankException()
                }
                viewModel.getGeeting()
            } catch (e: InputNullOrBlankException) {
                editSalary.error = e.message
            }
        }
    }
}