package com.example.cars.app.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.cars.R
import com.example.cars.utils.ext.openFragment
import com.example.cars.app.presentation.fragments.*
import com.example.cars.app.presentation.viewModels.MainActivityViewModel
import com.example.cars.databinding.ActivityMainBinding
import com.example.cars.utils.ext.appComponent
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.koin.androidx.viewmodel.ext.android.viewModel
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private val bottomNav by lazy {
        findViewById<BottomNavigationView>(R.id.bottom_navigation)
    }

    lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var mainActivityViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        appComponent.inject(this)
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