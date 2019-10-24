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
        updateCounter(viewModel.counter)
        increaseButton.setOnClickListener {
            increaseCounter()
        }
        decreaseButton.setOnClickListener {
            decreaseCounter()
        }
    }

    fun increaseCounter(){
        updateCounter(viewModel.counter + 1)
    }

    fun decreaseCounter(){
        updateCounter(viewModel.counter - 1)
    }

    private fun updateCounter(newValue: Int){
        viewModel.counter = newValue
        counterTextView.text = viewModel.counter.toString()
    }
}