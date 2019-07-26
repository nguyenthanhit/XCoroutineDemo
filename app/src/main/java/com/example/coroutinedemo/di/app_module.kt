package com.example.coroutinedemo.di

import com.example.coroutinedemo.repo.MovieRepository
import com.example.coroutinedemo.viewmodel.MovieViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single {
        MovieRepository(get())
    }

    viewModel { MovieViewModel(get()) }
}