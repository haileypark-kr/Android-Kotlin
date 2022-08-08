package com.example.fastcampuskotlin

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ActivityStack1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stack1)


        (findViewById<TextView>(R.id.tv1)).setOnClickListener {
            startActivity(Intent(this@ActivityStack1, ActivityStack1::class.java))
        }
        (findViewById<TextView>(R.id.tv2)).setOnClickListener {
            val intent = Intent(this@ActivityStack1, ActivityStack2::class.java)
            startActivity(intent)
        }
        (findViewById<TextView>(R.id.tv3)).setOnClickListener {
            startActivity(Intent(this@ActivityStack1, ActivityStack3::class.java))
        }
    }
}