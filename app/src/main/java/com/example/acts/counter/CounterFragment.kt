package com.example.acts.counter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.example.acts.databinding.FragmentCounterBinding

class CounterFragment : Fragment() {

    private lateinit var binding: FragmentCounterBinding
    private val viewModel by viewModels<CounterViewModel> {
        SavedStateViewModelFactory(requireActivity().application, this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCounterBinding.inflate(inflater, container, false)
            .apply {
                lifecycleOwner = viewLifecycleOwner
                viewModel = this@CounterFragment.viewModel
            }

        initObservers()

        return binding.root
    }

    private fun initObservers(){
        viewModel.uiEventLiveData.observe(viewLifecycleOwner){
            val directions = CounterFragmentDirections.actionCounterFragmentToCollectFragment()
            findNavController().navigate(directions)
        }
    }
}