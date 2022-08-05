package com.example.fastcampuskotlin

import android.content.ComponentName
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("LifeCycle", "onCreate")


        // 명시적 인텐트 사용법 1. ComponentName을 직접 입력
        val intentOne: TextView = findViewById(R.id.explicit_tv1)

        intentOne.setOnClickListener {
            val intent: Intent = Intent()
            val componentName: ComponentName = ComponentName(
                "com.example.fastcampuskotlin",
                "com.example.fastcampuskotlin.MainActivity2"
            )

            intent.component = componentName
            startActivity(intent)
        }

        // 명시적 인텐트 사용법2. 이거 쓰기.
        (findViewById<TextView>(R.id.explicit_tv2)).apply {
            this.setOnClickListener {
                startActivity(Intent(this@MainActivity, MainActivity2::class.java))
            }
        }

        // 명시적 인텐트 사용법3. 데이터 전달하기
        (findViewById<TextView>(R.id.explicit_tv3)).apply {
            this.setOnClickListener {
                val intent: Intent = Intent(this@MainActivity, MainActivity2::class.java)
                intent.putExtra("extra-data", "data-1")

                startActivity(intent)
            }
        }

        // 명시적 인텐트 사용법4. 결과 받기
        // request code: 보낸 곳을 구분하기 위해서.
        // intent 1 => 2 : requestCode = 1
        // intent 1 => 3 : requestCode = 2
        // intent 1 => 4 : requestCode = 3
        (findViewById<TextView>(R.id.explicit_tv4)).apply {
            this.setOnClickListener {
                val intent: Intent = Intent(this@MainActivity, MainActivity2::class.java)

                startActivityForResult(intent, 1) //deprecated. 5번거 사용해라.
            }
        }


        // 명시적 인텐트 사용법5. 결과 받기 + ActivityResult API 사용
        // ActivityResult : request code가 없음. (== request 보낸 사람을 구분할 수 있음)
        val startActivityLauncher: ActivityResultLauncher<Intent> = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            // 이 부분이 onActivityResult 에 해당되는 부분.
            // 각각의 intent가 처리되는 곳이 별도로 있어서 request code로 구분이 필요 없음.

            when (it.resultCode) {
                RESULT_OK -> {
                    val res: String? = it.data?.extras?.getString("result")
                    if (res != null) {
                        Log.d("ActivityResult", res)
                    }
                }
            }
        }


        (findViewById<TextView>(R.id.explicit_tv5)).apply {
            this.setOnClickListener {
                val intent: Intent = Intent(this@MainActivity, MainActivity2::class.java)
                intent.putExtra("userName", "soohyun")
                startActivityLauncher.launch(intent)
            }
        }


        // 명시적 인텐트 사용법6. 이미지 전달 Action - 이미지의 URI를 넘겨주기 (이걸 많이 사용하진 않음)
        (findViewById<TextView>(R.id.explicit_tv6)).apply {
            this.setOnClickListener {
                val intent: Intent = Intent(this@MainActivity, MainActivity2::class.java).apply {
                    val imageUri =
                        Uri.parse("android.resource://" + packageName + "/drawable/download")

                    this.action = Intent.ACTION_SEND
                    this.putExtra(
                        Intent.EXTRA_STREAM,
                        imageUri
                    ) // 이미지는 key value 형식으로 전달하는게 아니라 stream으로 전달
                    this.setType("image/*")
                }

                startActivity(intent)
            }
        }

        // 인텐트를 이용해서 데이터 전달이 가능하다
        // - 인텐트를 이용해서 key value 데이터를 전달한다
        // - 인텐트를 이용해서 이미지를 전달한다

    }


    /*
        모든 intent가 이 메소드에서 처리되어서 request code로 요청을 구분해야 함.
        resultCode: status code
     */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // requestCode로 보낸 곳이 1번이면 뭐 하고, 2번이면 뭐 하고 구분.
        when (requestCode) {
            1 -> {
                when (resultCode) {

                    RESULT_OK -> {
                        val data: String? = data?.extras?.getString("result")
                        if (data != null) {
                            Log.d("onActivityResult", data)
                        }
                    }
                }
            }
            2 -> {

            }
        }

    }

    override fun onStart() {
        super.onStart()

        Log.d("LifeCycle", "onStart")

    }


    override fun onResume() {
        super.onResume()

        Log.d("LifeCycle", "onResume")

    }

    override fun onPause() {
        super.onPause()
        Log.d("LifeCycle", "onPause")

    }

    override fun onStop() {
        super.onStop()
        Log.d("LifeCycle", "onStop")

    }


    override fun onRestart() {
        super.onRestart()
        Log.d("LifeCycle", "onRestart")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LifeCycle", "onDestroy")

    }


}