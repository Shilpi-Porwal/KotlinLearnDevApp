package com.example.kotlinlearndevapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinlearndevapp.Helper.RetrofitInstance
import kotlinx.coroutines.launch
import model.Moview
import model.ResultSet

class MovieViewModel:ViewModel() {
    private var movieLiveData = MutableLiveData<List<ResultSet>>()
    suspend fun getPopularMovies(){
        viewModelScope.launch {
            val result = RetrofitInstance.api.getPopularMovies("69d66957eebff9666ea46bd464773cf0")
                .body()
        }
    }

    fun observeMovieLiveData() : LiveData<List<ResultSet>> {
        return movieLiveData
    }
}