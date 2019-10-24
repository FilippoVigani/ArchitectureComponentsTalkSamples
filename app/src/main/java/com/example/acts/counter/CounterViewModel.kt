package com.example.acts.counter

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class CounterViewModel(private val state: SavedStateHandle) : ViewModel() {
    var counter = state.get<Int>(STATE_COUNTER) ?: 0
        set(value) {
            field = value
            state.set(STATE_COUNTER, counter)
        }

    fun increaseCounter(){
        counter++
    }

    fun decreaseCounter(){
        counter++
    }

    companion object{
        const val STATE_COUNTER = "COUNTER"
    }
}