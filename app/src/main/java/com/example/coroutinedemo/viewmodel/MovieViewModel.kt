package com.example.coroutinedemo.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coroutinedemo.repo.MovieRepository
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import kotlin.system.measureTimeMillis

class MovieViewModel(private val repo: MovieRepository) : ViewModel() {

    private var job: Job = Job()

    val progressBarLiveData = MutableLiveData<Boolean>()

    private val uiScope = CoroutineScope(Dispatchers.Main + job)

    fun getMovies() {

        uiScope.launch {
            val time = measureTimeMillis {
                progressBarLiveData.value = true
                val result = repo.getMovieList()

                result.movies?.map {
                    repo.getMovieDetail(it.id ?: 0)
                }

//                movie?.map {
//                    async(Dispatchers.Default) {
//                        repo.getMovieDetail(it.id ?: 0)
//                    }
//                }
                progressBarLiveData.value = false
            }

            Log.d("Jayz", "Time to complete $time")
        }

    }

    override fun onCleared() {
        super.onCleared()
        uiScope.coroutineContext.cancelChildren()
    }
}