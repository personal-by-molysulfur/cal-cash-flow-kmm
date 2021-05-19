package com.molysulfur.app.calcashflow.android.ui.getstarted

import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels

class ManageFormFragment : Fragment() {
    private val viewModel: GetStartedViewModel by activityViewModels()
    companion object {
        fun newInstance(): ManageFormFragment = ManageFormFragment()
    }
}