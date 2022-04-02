package com.example.cars.app.presentation.fragments

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.cars.R
import com.example.cars.app.presentation.recyclers.horizontalRecyclerInAddCar.HorizontalImageAdapter
import com.example.cars.app.presentation.recyclers.recyclerInModelsBottom.clickListener.ReturnAddModelButton
import com.example.cars.app.presentation.viewModels.AddPostFragmentViewModel
import com.example.cars.utils.actionSelectors.CreateUserPostResult.*
import com.example.cars.utils.ext.appComponent
import com.example.cars.utils.ext.dialog
import com.example.cars.utils.ext.openFragment
import kotlinx.android.synthetic.main.fragment_add_post.*

class AddPostFragment : Fragment(R.layout.fragment_add_post) {

    companion object {
        const val TAG = "AddCarFragment"
        fun newInstance() = AddPostFragment()
    }

    private val addPostFragmentViewModel: AddPostFragmentViewModel by viewModels {
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
            addPostFragmentViewModel.savePost(
                images = null,
                title = addTitle.text.toString(),
                carModel = addCarModel.text.toString(),
                description = addDescription.text.toString(),
                price = addPrice.text.toString(),
                personName = addName.text.toString(),
                email = addEmail.text.toString(),
                phoneNumber = addPhoneNumber.text.toString()
            )
        }

        addPostFragmentViewModel.validateUserPostResponse.observe(viewLifecycleOwner) { createUserPostResult ->
            when (createUserPostResult) {
                is PostCreationSuccess -> {
                    requireActivity().apply {
                        openFragment(
                            MainPageFragment.newInstance(),
                            MainPageFragment.TAG,
                            R.id.container
                        )
                    }
                }
                is PostCreationFailed -> {
                    requireActivity().dialog(PostCreationFailed.MESSAGE)
                }
            }
        }
    }

}