package com.example.cars.app.presentation.addPost

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.cars.R
import com.example.cars.app.presentation.addPost.bottomSheet.CarModelsBottomFragment
import com.example.cars.app.presentation.mainPage.MainPageFragment
import com.example.cars.app.presentation.addPost.recycler.HorizontalImageAdapter
import com.example.cars.app.presentation.addPost.bottomSheet.recycler.clickListeners.ReturnAddModelButton
import com.example.cars.app.presentation.addPost.actionSelector.CreateUserPostResult.*
import com.example.cars.databinding.FragmentAddPostBinding
import com.example.cars.utils.ext.appComponent
import com.example.cars.utils.ext.dialog
import com.example.cars.utils.ext.openFragment
import kotlinx.android.synthetic.main.fragment_add_post.*

class AddPostFragment : Fragment(R.layout.fragment_add_post) {

    companion object {
        const val TAG = "AddCarFragment"
        fun newInstance() = AddPostFragment()
    }

    private val binding: FragmentAddPostBinding by viewBinding()

    private val addPostFragmentViewModel: AddPostFragmentViewModel by viewModels {
        requireActivity().appComponent.viewModelsFactory()
    }

    private val recycler by lazy {
        binding.addCarRecycler
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
        recycler.adapter = adapter
    }

    private fun sendPost() {
        sendPost.setOnClickListener {
            addPostFragmentViewModel.savePost(
                images = null,
                title = binding.addTitle.text.toString(),
                carModel = binding.addCarModel.text.toString(),
                description = binding.addDescription.text.toString(),
                price = binding.addPrice.text.toString(),
                personName = binding.addName.text.toString(),
                email = binding.addEmail.text.toString(),
                phoneNumber = binding.addPhoneNumber.text.toString()
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