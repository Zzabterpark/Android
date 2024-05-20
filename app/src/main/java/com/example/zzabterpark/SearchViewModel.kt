package com.example.zzabterpark

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SearchViewModel : ViewModel() {
    private val _recentSearches = MutableLiveData<MutableList<String>>(mutableListOf())
    val recentSearches: LiveData<MutableList<String>> get() = _recentSearches

    private val _realtimeSearches = MutableLiveData<MutableList<String>>(mutableListOf())
    val realtimeSearches: LiveData<MutableList<String>> get() = _realtimeSearches
//
//    init {
//        updateRealtimeSearches(listOf("김지원", "임영웅", "신한카드 SOL페이 스퀘어 라이브홀", "차은우", "임윤찬", "위버스", "시카고", "캠핑장", "프랑켄슈타인", "팬미팅"))
//    }

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

    fun updateRealtimeSearches(newSearches: List<String>) {
        _realtimeSearches.value = newSearches.toMutableList()
    }
}
