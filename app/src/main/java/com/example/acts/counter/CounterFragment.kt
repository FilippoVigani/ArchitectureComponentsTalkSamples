package com.example.acts.counter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.SavedStateViewModelFactory
import com.example.acts.R
import com.example.acts.databinding.FragmentCounterBinding

class CounterFragment: Fragment() {

    private lateinit var binding: FragmentCounterBinding
    private val viewModel by viewModels<CounterViewModel> {
        SavedStateViewModelFactory(requireActivity().application,this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCounterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateCounter()
        binding.increaseButton.setOnClickListener {
            viewModel.increaseCounter()
            updateCounter()
        }
        binding.decreaseButton.setOnClickListener {
            viewModel.decreaseCounter()
            updateCounter()
        }
    }

    private fun updateCounter(){
        binding.counterTextView.text = viewModel.counter.toString()
    }
}