package com.example.cars.app.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.cars.R
import com.example.cars.app.presentation.viewModels.PersonalPageFragmentViewModel
import com.example.cars.utils.ext.appComponent
import javax.inject.Inject

class PersonalPageFragment : Fragment(R.layout.fragment_personal_page) {

    companion object {
        const val TAG = "PersonalPageFragment"
        fun newInstance() = PersonalPageFragment()
    }

    @Inject
    lateinit var personalPageFragmentViewModel: PersonalPageFragmentViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().appComponent.inject(this)
    }
}