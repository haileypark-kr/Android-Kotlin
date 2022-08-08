package com.example.fastcampuskotlin

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResourceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resource)

        (findViewById<TextView>(R.id.tv1)).setOnClickListener {
            (it as TextView).text = resources.getText(R.string.hello)

            /*
            아래는 resources 에서 리소스를 가져오는 여러 가지 방법들!
            - minSdk 버전에 따라서 아래 중 되는게 다를 수 있음.

            theme는 null 넣든가 현재 적용중인 테마 (this.theme) 넣든가.
             */
            it.background = resources.getDrawable(R.drawable.download, this.theme)
//            it.background = ContextCompat.getDrawable(this, R.drawable.download)
//            it.background = ResourcesCompat.getDrawable(resources, R.drawable.download, null)

        }

    }
}