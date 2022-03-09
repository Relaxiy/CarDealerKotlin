package com.example.cars.app.presentation.fragments

import androidx.fragment.app.Fragment
import com.example.cars.R
import com.example.cars.app.presentation.viewModels.FavouriteCarsFragmentViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavouriteCarsFragment : Fragment(R.layout.fragment_favourite_cars) {

    companion object {
        const val TAG = "FavouriteCarsFragment"
        fun newInstance() = FavouriteCarsFragment()
    }

    private val favouriteCarsFragmentViewModel: FavouriteCarsFragmentViewModel by viewModel()
}