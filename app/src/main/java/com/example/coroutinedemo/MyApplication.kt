package com.example.coroutinedemo

import android.app.Application
import com.example.coroutinedemo.di.appModule
import com.example.coroutinedemo.di.remotModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(remotModule, appModule)
        }
    }
}