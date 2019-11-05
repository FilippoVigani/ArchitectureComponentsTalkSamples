package com.example.acts.collect

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class CollectViewModel(private val state: SavedStateHandle) : ViewModel() {

    private val _count = MutableLiveData<Int>()
    val count: LiveData<Int> = _count

    fun setCount(count: Int){
        _count.value = count
    }
}