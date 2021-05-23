package com.molysulfur.app.calcashflow.android.ui.getstarted

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.molysulfur.app.calcashflow.android.R
import com.molysulfur.app.calcashflow.vo.Manage
import kotlinx.android.synthetic.main.calcashflow_fragment_manage.calcashflow_salary_manage_text_field_saving as editTextSaving

class ManageFormFragment : Fragment(R.layout.calcashflow_fragment_manage) {
    private val viewModel: GetStartedViewModel by activityViewModels()

    private var savingManage: Manage = Manage()
    private var withdrawManage: Manage = Manage()
    private var playingManage: Manage = Manage()
    private var investingManage: Manage = Manage()

    companion object {
        fun newInstance(): ManageFormFragment = ManageFormFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prepare()
    }

    private fun prepare() {
        editTextSaving.onPriceChange = {
            viewModel.calculateSaving(savingManage)
        }
        editTextSaving.onPercentageChange = {
            viewModel.calculateSaving()
        }
    }

}