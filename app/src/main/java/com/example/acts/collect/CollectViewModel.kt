package com.example.acts.collect

import android.app.Application
import androidx.lifecycle.*
import com.example.acts.collect.data.MeeseeksRepository
import kotlinx.coroutines.flow.collect

class CollectViewModel(application: Application) : AndroidViewModel(application) {

    private val meeseeksRepository by lazy { MeeseeksRepository(application) }

    private val _count = MutableLiveData<Int>()
    val count: LiveData<Int> = _count

    fun setCount(count: Int) {
        _count.value = count
    }

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    val meeseeks = Transformations.switchMap(_count) {
        liveData {
            _loading.postValue(true)
            meeseeksRepository.getMeeseeks(it).collect {
                emit(it)
            }
            _loading.postValue(false)
        }
    }
}