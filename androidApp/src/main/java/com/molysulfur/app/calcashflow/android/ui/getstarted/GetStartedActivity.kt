package com.molysulfur.app.calcashflow.android.ui.getstarted

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.lifecycle.Observer
import com.molysulfur.app.calcashflow.android.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GetStartedActivity : AppCompatActivity() {

    private val viewModel: GetStartedViewModel by viewModels()

    private var salary: Float = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calcashflow_activity_getstarted)

        viewModel.submitSalary.observe(this, submitSalaryObserver)

        supportFragmentManager.commit {
            replace(R.id.calcashflow_getstarted_layout_container, SalaryFormFragment.newInstance())
        }
    }


    private val submitSalaryObserver: Observer<Float> = Observer<Float> { salary ->
        this.salary = salary
        supportFragmentManager.commit {
            replace(R.id.calcashflow_getstarted_layout_container, ManageFormFragment.newInstance())
        }
    }
}