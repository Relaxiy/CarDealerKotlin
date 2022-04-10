package com.example.cars.app.presentation.messagesPage

import androidx.fragment.app.Fragment
import com.example.cars.R

class MessagesFragment : Fragment(R.layout.fragment_messages) {
    companion object{
        const val TAG = "MessagesFragment"
        fun newInstance() = MessagesFragment()
    }
}