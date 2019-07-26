package com.example.coroutinedemo

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.coroutinedemo.viewmodel.MovieViewModel
import kotlinx.android.synthetic.main.activity_b.*
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.koin.androidx.viewmodel.ext.android.viewModel

class DemoB : AppCompatActivity() {

    private val movieViewModel: MovieViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b)


        movieViewModel.progressBarLiveData.observe(this, Observer {
            progressBar.visibility = if (it) View.VISIBLE else View.GONE
        })

        btnCall.setOnClickListener {
            movieViewModel.getMovies()
        }
    }

}