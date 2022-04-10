package com.example.cars.app.presentation.carModelsPage

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cars.R
import com.example.cars.app.presentation.carModelsPage.recycler.CarAdapter
import com.example.cars.app.presentation.carModelsPage.recycler.clickListeners.ItemClickListener
import com.example.cars.utils.ext.appComponent
import kotlinx.android.synthetic.main.fragment_car_models.*

class CarModelsFragment : Fragment(R.layout.fragment_car_models) {

    companion object {
        const val TAG = "CarsModelFragment"
        fun newInstance() = CarModelsFragment()
    }

    private val carModelsFragmentViewModel: CarModelsFragmentViewModel by viewModels {
        requireActivity().appComponent.viewModelsFactory()
    }

    private val adapter by lazy { CarAdapter(openFragmentByItemClick) }
    private val recycler by lazy { view?.findViewById<RecyclerView>(R.id.car_models_recycle) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
    }

    private val openFragmentByItemClick by lazy {
        object : ItemClickListener {
            override fun itemClick() {

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