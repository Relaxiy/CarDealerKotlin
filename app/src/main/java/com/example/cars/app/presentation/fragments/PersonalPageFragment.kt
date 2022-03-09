package com.example.cars.app.presentation.fragments

import androidx.fragment.app.Fragment
import com.example.cars.R
import com.example.cars.app.presentation.viewModels.PersonalPageFragmentViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PersonalPageFragment : Fragment(R.layout.fragment_personal_page) {

    companion object {
        const val TAG = "PersonalPageFragment"
        fun newInstance() = PersonalPageFragment()
    }

    private val personalPageFragmentViewModel: PersonalPageFragmentViewModel by viewModel()

}