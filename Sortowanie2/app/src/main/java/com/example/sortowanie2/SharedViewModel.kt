package com.example.sortowanie2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {

    private val _text = MutableLiveData<String>()
    val text: LiveData<String> get() = _text

    private val _sortAlgorithm = MutableLiveData<SortAlgorithm>()
    val sortAlgorithm: LiveData<SortAlgorithm> get() = _sortAlgorithm

    fun setText(newText: String) {
        _text.value = newText
    }

    fun setSortAlgorithm(algorithm: SortAlgorithm) {
        _sortAlgorithm.value = algorithm
    }
}
