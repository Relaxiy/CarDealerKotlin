package com.example.cars

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cars.utils.ext.openFragment
import com.example.cars.app.presentation.fragments.*
import com.example.cars.databinding.ActivityMainBinding
import com.example.cars.registration.presentation.fragments.LoginUserFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private val bottomNav by lazy {
        findViewById<BottomNavigationView>(R.id.bottom_navigation)
    }
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        initHomeFragment()
        initBottomNavMenu()
    }

    private fun initHomeFragment() {
        openFragment(LoginUserFragment.newInstance(), LoginUserFragment.TAG, R.id.container)
    }

    private fun initBottomNavMenu() {
        binding.apply {

            bottomNav.setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.home -> {
                        openFragment(
                            MainPageFragment.newInstance(),
                            MainPageFragment.TAG,
                            R.id.container
                        )
                    }
                    R.id.to_cars -> {
                        openFragment(
                            CarModelsFragment.newInstance(),
                            CarModelsFragment.TAG,
                            R.id.container
                        )
                    }
                    R.id.add_car_button -> {
                        openFragment(
                            AddCarFragment.newInstance(),
                            AddCarFragment.TAG,
                            R.id.container
                        )
                    }
                    R.id.favourites_button -> {
                        openFragment(
                            FavouritePostsFragment.newInstance(),
                            FavouritePostsFragment.TAG,
                            R.id.container
                        )
                    }
                    R.id.login_button -> {
                        openFragment(
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