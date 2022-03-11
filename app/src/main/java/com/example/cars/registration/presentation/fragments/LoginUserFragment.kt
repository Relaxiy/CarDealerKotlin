package com.example.cars.registration.presentation.fragments

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import androidx.fragment.app.Fragment
import com.example.cars.R
import com.example.cars.registration.domain.models.User
import com.example.cars.registration.presentation.viewModels.LoginSharedViewModel
import com.example.cars.utils.ext.dialog
import com.example.cars.utils.ext.isEmail
import com.example.cars.utils.ext.openFragment
import kotlinx.android.synthetic.main.fragment_login_user.*
import kotlinx.android.synthetic.main.fragment_password_input.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import java.text.SimpleDateFormat
import java.util.*

class LoginUserFragment : Fragment(R.layout.fragment_login_user) {

    companion object {
        const val TAG = "LoginUserFragment"
        fun newInstance() = LoginUserFragment()
    }

    private val loginSharedViewModel: LoginSharedViewModel by sharedViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initDate()
        nextFragment()
    }

    private fun initDate() {
        val calendar = Calendar.getInstance()
        val datePicker = DatePickerDialog.OnDateSetListener { view, year, month, day ->
            calendar.set(Calendar.YEAR, year)
            calendar.set(Calendar.MONTH, month)
            calendar.set(Calendar.DAY_OF_MONTH, day)
            updateLabel(calendar)
        }
        date.setOnClickListener {
            DatePickerDialog(
                requireContext(),
                datePicker,
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
    }

    private fun updateLabel(calendar: Calendar) {
        val format = "dd/MM/yyyy"
        val sdf = SimpleDateFormat(format, Locale.UK)
        date.setText(sdf.format(calendar.time))
    }

    private fun nextFragment() {
        toPasswordInput.setOnClickListener {
            if (inputFirstName.text.isEmpty() ||
                inputLastName.text.isEmpty() ||
                date.text.isEmpty() ||
                inputEmail.text.isEmpty() ||
                !inputEmail.text.toString().isEmail()
            ) {
                requireActivity().dialog()
            } else {
                loginSharedViewModel.setUser(
                    createUser()
                )
                requireActivity().apply {
                    openFragment(
                        PasswordInputFragment.newInstance(),
                        PasswordInputFragment.TAG,
                        R.id.container
                    )
                }
            }
        }
    }

    fun createUser(): User {
        return User(
            firstName = inputFirstName.text.toString(),
            lastName = inputLastName.text.toString(),
            birthday = date.text.toString(),
            email = inputEmail.text.toString(),
            password = null
        )
    }
}