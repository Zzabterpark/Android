package com.example.zzabterpark

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.zzabterpark.data.Event

class SearchViewModel : ViewModel() {
    private val _recentSearches = MutableLiveData<MutableList<String>>(mutableListOf())
    val recentSearches: LiveData<MutableList<String>> get() = _recentSearches

    private val _realtimeSearches = MutableLiveData<MutableList<String>>(mutableListOf())
    val realtimeSearches: LiveData<MutableList<String>> get() = _realtimeSearches

    private val _events = listOf(
        Event(R.drawable.musical_image1, "Les Misérables", "2024-06-01"),
        Event(R.drawable.musical_image2, "The Phantom of the Opera", "2024-07-15"),
        Event(R.drawable.musical_image3, "Hamilton", "2024-08-20"),
        // 더 많은 이벤트 추가 가능
    )

    private val _searchResults = MutableLiveData<List<Event>>()
    val searchResults: LiveData<List<Event>> get() = _searchResults

    fun addSearch(search: String) {
        _recentSearches.value?.apply {
            if (!contains(search)) {
                add(0, search)
                if (size > 10) removeLast() // 최근 검색어 10개로 제한
                _recentSearches.value = this // 옵저버에게 알림
            }
        }
        performSearch(search)
    }

    fun clearAllSearches() {
        _recentSearches.value = mutableListOf()
    }

    fun updateRealtimeSearches(newSearches: List<String>) {
        _realtimeSearches.value = newSearches.toMutableList()
    }

    fun performSearch(query: String) {
        _searchResults.value = _events.filter { it.title.contains(query, ignoreCase = true) }
    }
}
