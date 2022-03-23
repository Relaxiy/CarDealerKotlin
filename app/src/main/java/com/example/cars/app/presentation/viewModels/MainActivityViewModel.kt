package com.example.cars.app.presentation.viewModels

import android.app.Activity
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import com.example.cars.R
import com.example.cars.app.presentation.fragments.*
import com.example.cars.databinding.ActivityMainBinding
import com.example.cars.utils.ext.openFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import javax.inject.Inject

class MainActivityViewModel @Inject constructor() : ViewModel() {

    fun initBottomNavMenu(
        binding: ActivityMainBinding,
        bottomNav: BottomNavigationView,
        mainActivity: FragmentActivity
    ) {
        binding.apply {

            bottomNav.setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.home -> {
                        mainActivity.openFragment(
                            MainPageFragment.newInstance(),
                            MainPageFragment.TAG,
                            R.id.container
                        )
                    }
                    R.id.to_cars -> {
                        mainActivity.openFragment(
                            CarModelsFragment.newInstance(),
                            CarModelsFragment.TAG,
                            R.id.container
                        )
                    }
                    R.id.add_car_button -> {
                        mainActivity.openFragment(
                            AddCarFragment.newInstance(),
                            AddCarFragment.TAG,
                            R.id.container
                        )
                    }
                    R.id.favourites_button -> {
                        mainActivity.openFragment(
                            FavouritePostsFragment.newInstance(),
                            FavouritePostsFragment.TAG,
                            R.id.container
                        )
                    }
                    R.id.login_button -> {
                        mainActivity.openFragment(
                            PersonalPageFragment.newInstance(),
                            PersonalPageFragment.TAG,
                            R.id.container
                        )
                    }
                }
                true
            }
        }
    }
}