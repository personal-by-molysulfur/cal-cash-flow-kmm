package com.molysulfur.app.calcashflow.android.ui.getstarted

import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.molysulfur.app.calcashflow.android.R

class ManageFormFragment : Fragment(R.layout.calcashflow_fragment_manage) {
    private val viewModel: GetStartedViewModel by activityViewModels()

    companion object {
        fun newInstance(): ManageFormFragment = ManageFormFragment()
    }


}