package com.example.acts.counter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProviders
import com.example.acts.R
import kotlinx.android.synthetic.main.fragment_counter.*

class CounterFragment: Fragment() {

    //private val viewModel by lazy { ViewModelProviders.of(this).get(CounterViewModel::class.java) }
    private val viewModel by viewModels<CounterViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_counter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateCounter()
        increaseButton.setOnClickListener {
            viewModel.increaseCounter()
            updateCounter()
        }
        decreaseButton.setOnClickListener {
            viewModel.decreaseCounter()
            updateCounter()
        }
    }

    private fun updateCounter(){
        counterTextView.text = viewModel.counter.toString()
    }
}