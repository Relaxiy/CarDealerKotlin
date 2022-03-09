package com.example.cars.app.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cars.R
import com.example.cars.app.domain.models.CarModel
import com.example.cars.app.presentation.recyclers.recyclerInModelsBottom.ModelAdapter
import com.example.cars.app.presentation.recyclers.recyclerInModelsBottom.clickListener.CarModelClickListener
import com.example.cars.app.presentation.recyclers.recyclerInModelsBottom.clickListener.ReturnAddModelButton
import com.example.cars.app.presentation.viewModels.CarModelsBottomFragmentViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class CarModelsBottomFragment(private val returnAddModelButton: ReturnAddModelButton) :
    BottomSheetDialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.car_model_bottom_sheet, container, false)

    companion object {
        const val TAG = "CarModelsBottomFragment"
        fun newInstance(returnAddModelButton: ReturnAddModelButton) =
            CarModelsBottomFragment(returnAddModelButton)
    }

    private val carModelsBottomFragmentViewModel: CarModelsBottomFragmentViewModel by viewModel()
    private val adapter by lazy {
        ModelAdapter(carModelClickListener)
    }

    private val recycler by lazy {
        view?.findViewById<RecyclerView>(R.id.recycle_bottom_sheet)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
    }

    private val carModelClickListener by lazy {
        object : CarModelClickListener{
            override fun carModelClick(carModel: CarModel) {
                val setModel = returnAddModelButton.returnButton()
                setModel?.setText(carModel.model)
                dismiss()
            }
        }
    }

    private fun initRecycler() {
        recycler?.adapter = adapter
        carModelsBottomFragmentViewModel.carModelsLiveData.observe(viewLifecycleOwner) { carModels ->
            adapter.setItems(carModels)
        }
    }

}