package com.example.cars.registration.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.cars.R
import com.example.cars.app.presentation.fragments.MainPageFragment
import com.example.cars.registration.presentation.viewModels.LoginSharedViewModel
import com.example.cars.utils.ext.dialog
import com.example.cars.utils.ext.openFragment
import kotlinx.android.synthetic.main.fragment_password_input.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class PasswordInputFragment : Fragment(R.layout.fragment_password_input) {

    companion object {
        const val TAG = "PasswordInputFragment"
        fun newInstance() = PasswordInputFragment()
    }

    private val loginSharedViewModel: LoginSharedViewModel by sharedViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setPassword()
    }

    private fun setPassword() {
        toHome.setOnClickListener {
            if (inputPasswordFirst.text.isEmpty()
                || inputPasswordSecond.text.isEmpty()
                || inputPasswordFirst.text.toString() != inputPasswordSecond.text.toString()
            ) {
                requireActivity().dialog()
            } else {
                loginSharedViewModel.setPassword(
                    inputPasswordSecond.text.toString()
                )
                loginSharedViewModel.sendUser()
                requireActivity().apply {
                    openFragment(
                        MainPageFragment.newInstance(),
                        MainPageFragment.TAG,
                        R.id.container
                    )
                }
            }
        }
    }
}