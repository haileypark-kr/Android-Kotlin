package com.example.fastcampuskotlin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ApplicationActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_application1)


        (findViewById<TextView>(R.id.tv1)).setOnClickListener {
            startActivity(Intent(this@ApplicationActivity1, ApplicationActivity2::class.java))
        }

        // application context에 메소드 만들어서 접근
        (findViewById<TextView>(R.id.tv_testMethod)).setOnClickListener {
            (applicationContext as MasterApplication).methodFromApplication()

            Log.d("ta", "" + (applicationContext as MasterApplication).userId)
        }
    }
}