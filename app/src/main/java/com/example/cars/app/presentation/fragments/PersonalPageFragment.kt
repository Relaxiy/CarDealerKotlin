package com.example.cars.app.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.cars.R
import com.example.cars.app.presentation.viewModels.PersonalPageFragmentViewModel
import com.example.cars.registration.presentation.viewModels.LoginActivityViewModel
import com.example.cars.registration.presentation.viewModels.RegisterActivityViewModel
import com.example.cars.utils.ext.appComponent
import kotlinx.android.synthetic.main.fragment_personal_page.*
import javax.inject.Inject

class PersonalPageFragment : Fragment(R.layout.fragment_personal_page) {

    companion object {
        const val TAG = "PersonalPageFragment"
        fun newInstance() = PersonalPageFragment()
    }

    private val personalPageFragmentViewModel: PersonalPageFragmentViewModel by viewModels {
        requireActivity().appComponent.viewModelsFactory()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bidAccount()
    }

    private fun bidAccount() {
    }


}