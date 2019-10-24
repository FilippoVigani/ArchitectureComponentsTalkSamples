package com.example.acts.counter

import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    var counter = 0

    fun increaseCounter(){
        counter++
    }

    fun decreaseCounter(){
        counter--
    }
}