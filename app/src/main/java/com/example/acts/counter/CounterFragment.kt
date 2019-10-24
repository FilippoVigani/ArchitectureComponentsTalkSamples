package com.example.acts.counter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.acts.R
import kotlinx.android.synthetic.main.fragment_counter.*
import kotlinx.android.synthetic.main.fragment_counter.view.*

class CounterFragment: Fragment() {

    var counter = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_counter, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateCounter(counter)
        increaseButton.setOnClickListener {
            increaseCounter()
        }
        decreaseButton.setOnClickListener {
            decreaseCounter()
        }
    }

    fun increaseCounter(){
        updateCounter(counter + 1)
    }

    fun decreaseCounter(){
        updateCounter(counter - 1)
    }

    private fun updateCounter(newValue: Int){
        counter = newValue
        counterTextView.text = counter.toString()
    }
}