package com.example.acts.counter

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.acts.core.SingleEventLiveData

class CounterViewModel(private val state: SavedStateHandle) : ViewModel() {
    private val _counter = state.getLiveData(STATE_COUNTER, 0)
    val counter: LiveData<Int> = _counter

    private val _uiEventLiveData = SingleEventLiveData<Event>()
    val uiEventLiveData: LiveData<Event> = _uiEventLiveData

    val counterText = Transformations.map(_counter){
        it.toString()
    }

    fun increaseCounter(){
        _counter.value = _counter.value?.plus(1)
    }

    fun decreaseCounter(){
        _counter.value = _counter.value?.minus(1)
    }

    fun collect(){
        _uiEventLiveData.value = Event.NavigateToCollect
    }

    enum class Event {
        NavigateToCollect
    }
    companion object{
        const val STATE_COUNTER = "COUNTER"
    }
}