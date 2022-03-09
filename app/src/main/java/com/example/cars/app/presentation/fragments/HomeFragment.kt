package com.example.cars.app.presentation.fragments

import androidx.fragment.app.Fragment
import com.example.cars.R
import com.example.cars.app.presentation.viewModels.HomeFragmentViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment(R.layout.fragment_home) {

    companion object {
        const val TAG = "HomeFragment"
        fun newInstance() = HomeFragment()
    }

    private val homeFragmentViewModel: HomeFragmentViewModel by viewModel()
}