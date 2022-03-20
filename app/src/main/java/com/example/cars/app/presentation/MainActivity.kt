package com.example.cars.app.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cars.R
import com.example.cars.utils.ext.openFragment
import com.example.cars.app.presentation.fragments.*
import com.example.cars.app.presentation.viewModels.MainActivityViewModel
import com.example.cars.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val bottomNav by lazy {
        findViewById<BottomNavigationView>(R.id.bottom_navigation)
    }

    lateinit var binding: ActivityMainBinding

    private val mainActivityViewModel: MainActivityViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initHomeFragment()
    }

    override fun onStart() {
        super.onStart()
        mainActivityViewModel.initBottomNavMenu(binding, bottomNav, this)
    }

    private fun initHomeFragment() {
        openFragment(MainPageFragment.newInstance(), MainPageFragment.TAG, R.id.container)
    }


}