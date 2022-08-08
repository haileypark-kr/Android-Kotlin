package com.example.fastcampuskotlin

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ActivityStack2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stack2)



        (findViewById<TextView>(R.id.tv1)).setOnClickListener {
            startActivity(Intent(this@ActivityStack2, ActivityStack1::class.java))
        }
        (findViewById<TextView>(R.id.tv2)).setOnClickListener {
            startActivity(Intent(this@ActivityStack2, ActivityStack2::class.java))
        }
        (findViewById<TextView>(R.id.tv3)).setOnClickListener {
            val intent = Intent(this@ActivityStack2, ActivityStack3::class.java)
            startActivity(intent)
        }
    }
}