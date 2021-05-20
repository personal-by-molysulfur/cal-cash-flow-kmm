package com.molysulfur.app.calcashflow.android.ui.getstarted

import android.os.Bundle
import android.text.Editable
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.molysulfur.app.calcashflow.android.R
import com.molysulfur.app.calcashflow.android.exception.InputNullOrBlankException
import kotlinx.android.synthetic.main.calcashflow_fragment_salary.calcashflow_salary_button_submit as btnSubmit
import kotlinx.android.synthetic.main.calcashflow_fragment_salary.calcashflow_salary_input_layout_salary as editSalary

class SalaryFormFragment : Fragment(R.layout.calcashflow_fragment_salary) {
    private val viewModel: GetStartedViewModel by activityViewModels()

    companion object {
        fun newInstance(): SalaryFormFragment = SalaryFormFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnSubmit.setOnClickListener {
            try {
                val salary: Editable? = editSalary.editText?.text
                if (salary.isNullOrBlank()) {
                    throw InputNullOrBlankException()
                }
                viewModel.getSalarySubmit(salary.toString().toFloat())
            } catch (e: InputNullOrBlankException) {
                editSalary.error = e.message
            }
        }

    }
}