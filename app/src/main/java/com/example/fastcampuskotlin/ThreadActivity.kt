package com.example.fastcampuskotlin

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ThreadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread)


        val currentThread = Thread.currentThread()
        Log.d(TAG, "onCreate: $currentThread")

//        Thread {
//            val currentThread = Thread.currentThread()
//
//            for (i in 1..1000) {
//                Log.d(TAG, "$currentThread : $i")
//            }
//        }.start()


        Thread {
            val currentThread = Thread.currentThread()
            Log.d(TAG, "$currentThread")

            val tv1 = findViewById<TextView>(R.id.tv1)

            // tv1.text = "hihi" // 에러가 나야할 것 같은데 안남. 왜?
            // ==> UI 관련 작업을 메인 쓰레드가 아닌 쓰레드에서 하려고 하면 해당 작업 메인 쓰레드의 queue에 들어감.
            // 따라서 에러가 안날 수도 있음

            runOnUiThread {
                tv1.text = "hihi"
            }

        }.start()

//        for (i in 1..1000) {
//            Log.d(TAG, "for: $i")
//        }
    }


    companion object {
        private const val TAG = "ThreadActivity"
    }
}