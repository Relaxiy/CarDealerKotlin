package com.example.cars.app.presentation.fragments

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.cars.R
import com.example.cars.app.data.network.models.AddPostItem
import com.example.cars.app.presentation.recyclers.horizontalRecyclerInAddCar.HorizontalImageAdapter
import com.example.cars.app.presentation.recyclers.recyclerInModelsBottom.clickListener.ReturnAddModelButton
import com.example.cars.app.presentation.viewModels.AddCarFragmentViewModel
import com.example.cars.registration.presentation.viewModels.LoginActivityViewModel
import com.example.cars.utils.ext.appComponent
import com.example.cars.utils.ext.dialog
import com.example.cars.utils.ext.isEmail
import com.example.cars.utils.ext.openFragment
import kotlinx.android.synthetic.main.fragment_add_car.*
import javax.inject.Inject

class AddCarFragment : Fragment(R.layout.fragment_add_car) {

    companion object {
        const val TAG = "AddCarFragment"
        fun newInstance() = AddCarFragment()
    }

    private val addCarFragmentViewModel: AddCarFragmentViewModel by viewModels {
        requireActivity().appComponent.viewModelsFactory()
    }

    private val recycler by lazy {
        view?.findViewById<RecyclerView>(R.id.addCarRecycler)
    }

    private val adapter by lazy {
        HorizontalImageAdapter(requireActivity().activityResultRegistry)
    }

    private val returnButton by lazy {
        object : ReturnAddModelButton {
            override fun returnButton(): EditText? = addCarModel
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
        carModelsBottomFragmentInit()
        sendPost()
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

    private fun initRecycler() {
        recycler?.adapter = adapter
    }

    private fun sendPost() {
        sendPost.setOnClickListener {
            if (addTitle.text.isEmpty() ||
                addCarModel.text.isEmpty() ||
                addDescription.text?.isEmpty() == true ||
                addPrice.text.isEmpty() ||
                addName.text.isEmpty() ||
                addEmail.text.isEmpty() ||
                addPhoneNumber.text.isEmpty() ||
                !addEmail.text.toString().isEmail()
            ) {
                requireActivity().dialog("Fields not valid!")
            } else {
                addCarFragmentViewModel.createPost(createPost())
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

    private fun createPost(): AddPostItem {
        return AddPostItem(
            images = listOf(),
            title = addTitle.text.toString(),
            carModel = addCarModel.text.toString(),
            description = addDescription.text.toString(),
            price = addPrice.text.toString(),
            personName = addName.text.toString(),
            email = addEmail.text.toString(),
            phoneNumber = addPhoneNumber.text.toString()
        )
    }

}