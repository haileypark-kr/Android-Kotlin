package com.example.fastcampuskotlin

import android.content.Intent
import android.content.Intent.*
import android.net.Uri
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        // 암시적 인텐트
        // - 전화, SMS, 구글 플레이스토어, website, map, 사진첩 등
        // 의도로 값을 전달할 때는 URI로 전달
        // - 전화는 tel:${전화번호} 입력

        val implicitIntentDial: TextView = findViewById(R.id.implicit_tv1)
        implicitIntentDial.setOnClickListener {
            val intent: Intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:010-1111-1111")) // 전화

            startActivity(intent) // startActivity에 intent 넣으면 이 인텐트 실행.
        }

        // 갤러리 열기
        val implicitIntentPic: TextView = findViewById(R.id.implicit_tv2)
        implicitIntentPic.setOnClickListener {
            val intent: Intent = Intent(Intent.ACTION_VIEW)
            intent.action = ACTION_VIEW
            intent.type = "image/*"
            intent.flags = FLAG_ACTIVITY_NEW_TASK

            startActivity(intent)
        }


        // MainActivity에서 받아온 데이터 전달
        // MainActivity2를 호출한 activity의 intent. context에 있는 intent 가져오는 것
        val intent = intent
        val data: String? = intent.extras?.getString("extra-data") // 있을수도 있고 없을 수도 있기 떄문에 ? 붙여줌
        val userName: String? = intent.extras?.getString("userName")

        if (data != null) {
            Log.d("MainActivity2 data", data)
        }


        // finish 버튼 누르면 결과 보내고 MainActivity2 종료하고 MainActivity로 간다.
        (findViewById<TextView>(R.id.finish_tv)).apply {
            this.setOnClickListener {
                val intent: Intent = Intent()
                intent.putExtra("result", "success $userName")
                setResult(RESULT_OK, intent)

                // main에서 이 결과를 받는 것은 다시 main activity로 갔을 때임.
                // 이 액티비티를 종료해야 main으로 갈 수 있음
                finish()
            }
        }


        // MainActivity에서 보낸 이미지로 기존의 imageView를 변경
        val imageView = findViewById<ImageView>(R.id.iv1)
        val uri = Uri.parse(
            intent.getParcelableExtra<Parcelable>(EXTRA_STREAM).toString()
        ) // intent에서 보낸 extra stream을 uri.parse로 받은 것

        imageView.setImageURI(uri)
//
//        intent.getParcelableExtra<>()
//        (findViewById<ImageView>(R.id.iv1)).apply {
//            thi
//        }
    }

}