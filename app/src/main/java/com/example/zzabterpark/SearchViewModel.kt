package com.example.zzabterpark

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SearchViewModel : ViewModel() {
    private val _recentSearches = MutableLiveData<MutableList<String>>(mutableListOf())
    val recentSearches: LiveData<MutableList<String>> get() = _recentSearches

    fun addSearch(search: String) {
        _recentSearches.value?.apply {
            if (!contains(search)) {
                add(0, search)
                if (size > 10) removeLast() // Keep the list to the last 10 searches
                _recentSearches.value = this // Notify observers
            }
        }
    }

    fun clearAllSearches() {
        _recentSearches.value = mutableListOf()
    }
}
