package com.example.cars.app.presentation.fragments

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.cars.R
import com.example.cars.app.presentation.recyclers.recyclerInModelsBottom.clickListener.ReturnAddModelButton
import com.example.cars.app.presentation.viewModels.AddCarFragmentViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddCarFragment : Fragment(R.layout.fragment_add_car) {

    companion object {
        const val TAG = "AddCarFragment"
        fun newInstance() = AddCarFragment()
    }

    private val addCarFragmentViewModel: AddCarFragmentViewModel by viewModel()

    private val addCarModel by lazy {
        view?.findViewById<EditText>(R.id.add_car_model)
    }

    private val returnButton by lazy {
        object : ReturnAddModelButton{
            override fun returnButton(): EditText? = addCarModel
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        carModelsBottomFragmentInit()
    }

    private fun carModelsBottomFragmentInit() {
        addCarModel?.setOnClickListener {
            val bottomFragment = CarModelsBottomFragment.newInstance(returnButton)
            bottomFragment.show(
                requireActivity().supportFragmentManager,
                CarModelsBottomFragment.TAG
            )
        }
    }


}