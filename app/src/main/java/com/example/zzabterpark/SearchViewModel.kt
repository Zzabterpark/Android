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
        Event(R.drawable.musical_image1, "뮤지컬 <레드북>", "2024-03-01 to 2024-03-31"),
        Event(R.drawable.musical_image2, "뮤지컬 <레미제라블>", "2024-04-01 to 2024-04-30"),
        Event(R.drawable.musical_image3, "뮤지컬 <La La Land>", "2024-05-01 to 2024-05-02"),
        Event(R.drawable.classic_image1, "파리 오페라 발레 에투알 갈라", "2024-07-20 to 2024-07-24"),
        Event(R.drawable.classic_image2, "국립발레단 <돈키호테>", "2024-06-05 to 2024-06-09"),
        Event(R.drawable.concert_image1, "백예린 전국 투어 [서울 파이널]", "2024-03-01 to 2024-03-31"),
        Event(R.drawable.concert_image2, "2024 카더가든 단독 콘서트 [Harmony]", "2024-04-01 to 2024-04-30"),
        Event(R.drawable.concert_image3, "QWER 단독 콘서트 [고민중독]", "2024-05-01 to 2024-05-02"),
        Event(R.drawable.theater_image1, "운빨로맨스", "2021-05-01 to 2024-06-30"),
        Event(R.drawable.theater_image2, "라면", "2024-02-01 to 2024-06-30"),
        Event(R.drawable.theater_image3, "이머시브씨어터 카지노", "2023-04-28 to 2024-06-30"),
    )

    private val _searchResults = MutableLiveData<List<Event>>()
    val searchResults: LiveData<List<Event>> get() = _searchResults

    fun addSearch(search: String) {
        _recentSearches.value?.apply {
            if (!contains(search)) {
                add(0, search)
                if (size > 10) removeLast()
                _recentSearches.value = this
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
