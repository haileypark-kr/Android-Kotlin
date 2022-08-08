package com.example.fastcampuskotlin

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.util.Log

class MasterApplication : Application() {

    val userId: Long = 1000


    override fun onCreate() {
        super.onCreate()

        Log.d("MasterApplication", "onCreate")


        // 모든 액티비티의 라이프사이클 관찰 가능
        registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
            override fun onActivityCreated(p0: Activity, p1: Bundle?) {
                Log.d("LifecycleCallbacks", "onActivityCreated")

            }

            override fun onActivityStarted(p0: Activity) {
                Log.d("LifecycleCallbacks", "onActivityStarted")
            }

            override fun onActivityResumed(p0: Activity) {
                Log.d("LifecycleCallbacks", "onActivityResumed")

            }

            override fun onActivityPaused(p0: Activity) {
                Log.d("LifecycleCallbacks", "onActivityPaused")

            }

            override fun onActivityStopped(p0: Activity) {
                Log.d("LifecycleCallbacks", "onActivityStopped")

            }

            override fun onActivitySaveInstanceState(p0: Activity, p1: Bundle) {
                Log.d("LifecycleCallbacks", "onActivitySaveInstanceState")

            }

            override fun onActivityDestroyed(p0: Activity) {
                Log.d("LifecycleCallbacks", "onActivityDestroyed")

            }

        })


        // 앱이 살아있는 동안에만 유지하는 정보들은 여기에서 저장

        // 모든 액티비티에서 사용할 것 같은 정보도 여기서 저장
    }

    fun methodFromApplication() {
        Log.d("MasterApplication", "methodFromApplication")
    }


    override fun onTerminate() {
        super.onTerminate()

        Log.d("MasterApplication", "onTerminate")

    }
}