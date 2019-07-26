package com.example.coroutinedemo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import kotlin.concurrent.thread
import kotlin.system.measureTimeMillis


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//
//        runBlocking {
//            Log.d("Jay", "${Thread.currentThread().name} - Before")
//
//            launch {
//                Log.d("Jay", "${Thread.currentThread().name} - Running")
//            }
//            Log.d("Jay", "Done")
//        }


//
        val t = measureTimeMillis {
            val sum1 = sum()
            val sum2 = sum()

            Log.d("Jay", "Total = ${sum1 + sum2}")
        }

        Log.d("Jay", "Time  = $t")

//
//
//        runBlocking {
//            val t = measureTimeMillis {
//                val sum1: Deferred<Int> = async {
//                    Log.d("Jay coroutine", Thread.currentThread().name)
//                    sum1()
//                }
//
//                val sum2 = async {
//                    sum1()
//                }
//
//                Log.d("Jay", "Total with coroutine= ${sum1.await() + sum2.await()}")
//            }
//            Log.d("Jay", "Time with coroutine = $t")
//        }
//
//        val job = GlobalScope.launch(Dispatchers.Main) {
//            countDownWithCoroutine()
//            tvCountDown.text = "Done!"
//        }
//
//
//        btnCancel.setOnClickListener {
//            job.cancel()
//        }
    }


    private suspend fun countDownWithCoroutine() {
        for (i in 200 downTo 1) { // countdown from 10 to 1
            tvCountDown.text = "Countdown $i ..." // update text
            delay(1000L) // wait half a second
        }
    }


    private fun countDown() {
        for (i in 200 downTo 1) { // countdown from 10 to 1
            tvCountDown.text = "Countdown $i ..."
            Thread.sleep(1000L) // wait half a second
        }
    }


    private fun counterWithThread() {
        var counter = 0
        val numberOfThreads = 100_000
        for (i in 1..numberOfThreads) {
            thread {
                counter += 1
                Log.d("Jayz", "${Thread.currentThread().name} --Created ${i} threads in.")
            }
        }
    }


    private fun counterWithCoroutine() {

        GlobalScope.launch {
            val jobs = List(200_000) {
                launch() {
                    Log.d("Jayz", "${Thread.currentThread().name} --Created ${it} threads in.")

                }
            }
            jobs.forEach { it.join() }
        }
//        runBlocking {
//            var counter = 0
//            val numberOfThreads = 100_000
//            for (i in 1..numberOfThreads) {
//                launch(Dispatchers.Default) {
//                    Log.d("Jayz", "${Thread.currentThread().name} --Created ${i} threads in.")
//
//                    counter += 1
//                }
//            }


//        }


    }

    private fun sum(): Int {
        Thread.sleep(5000L)
        return 100
    }

    private suspend fun sum1(): Int {
        delay(5000L)
        return 100
    }
}
