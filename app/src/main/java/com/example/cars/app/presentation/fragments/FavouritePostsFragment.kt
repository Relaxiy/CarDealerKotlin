package com.example.cars.app.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.cars.R
import com.example.cars.app.presentation.viewModels.FavouritePostsFragmentViewModel
import com.example.cars.utils.ext.appComponent
import javax.inject.Inject

class FavouritePostsFragment : Fragment(R.layout.fragment_favourite_posts) {

    companion object {
        const val TAG = "FavouriteCarsFragment"
        fun newInstance() = FavouritePostsFragment()
    }

    @Inject
    lateinit var favouritePostsFragmentView: FavouritePostsFragmentViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().appComponent.inject(this)
    }
}