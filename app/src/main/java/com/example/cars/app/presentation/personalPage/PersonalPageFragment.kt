package com.example.cars.app.presentation.personalPage

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.cars.R
import com.example.cars.utils.ext.appComponent

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
        bindAccount()
    }

    private fun bindAccount() {
    }


}