package com.example.cars.app.presentation.fragments

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cars.R
import com.example.cars.utils.ext.openFragment
import com.example.cars.app.presentation.recyclers.recyclerInCarModels.CarAdapter
import com.example.cars.app.presentation.recyclers.recyclerInCarModels.clickListeners.ItemClickListener
import com.example.cars.app.presentation.viewModels.CarModelsFragmentViewModel
import kotlinx.android.synthetic.main.fragment_car_models.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class CarModelsFragment : Fragment(R.layout.fragment_car_models) {

    companion object {
        const val TAG = "CarsModelFragment"
        fun newInstance() = CarModelsFragment()
    }

    private val carModelsFragmentViewModel: CarModelsFragmentViewModel by viewModel()

    private val adapter by lazy { CarAdapter(openFragmentByItemClick) }
    private val recycler by lazy { view?.findViewById<RecyclerView>(R.id.car_models_recycle) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
    }

    private val openFragmentByItemClick by lazy {
        object : ItemClickListener {
            override fun itemClick() {
                requireActivity().apply {
                    openFragment(
                        FavouriteCarsFragment.newInstance(),
                        FavouriteCarsFragment.TAG,
                        R.id.container
                    )
                }
            }
        }
    }

    private fun initRecycler() {
        recycler?.layoutManager = GridLayoutManager(requireContext(), 3)
        recycler?.adapter = adapter
        carModelsFragmentViewModel.carsLiveData.observe(viewLifecycleOwner) { carItem ->
            progress.visibility = ProgressBar.INVISIBLE
            adapter.setItems(carItem)
        }

    }

}