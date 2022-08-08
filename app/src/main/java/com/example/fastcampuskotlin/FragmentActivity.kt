package com.example.fastcampuskotlin

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        // 코드로 fragment 붙이기


        val fragmentManager = supportFragmentManager
        val fragment1 = Fragment1()

        // transaction: 작업의 단위 (DB처럼 깊은 뜻은 없음) --> 시작과 끝이 있음
        // beginTransaction - commit
        (findViewById<TextView>(R.id.tv_attach)).setOnClickListener {
            Log.d("FragmentActivity", "click attach")

            val transaction = fragmentManager.beginTransaction() // 작업의 시작


            // fragment에 데이터 전달하는 방법 : Bundle 사용하여 fragment의 argument로 등록
            // 데이터를 넘겨야 하는 일이 있으면 xml이 아닌 코드로 fragment 생성
            val bundle = Bundle()
            bundle.putString("key", "hello")
            fragment1.arguments = bundle

            transaction.replace(R.id.linearlayout_root, fragment1, "fragment1_tag1")

            transaction.commit() // 여기까지 작업 커밋해라

            /*
            commit 종류
            1. commit : 앱이 상태를 저장한 경우, commit 시 IllegalStateException 발생해서 실행할 수 없음. commit을 바로 실행하진 않고 main thread에 예약.
            2. commitAllowingStateLoss : 저장한 경우 예외가 발생하지 않고 그냥 손실
            3. commitNow : commit 바로 실행.
            4. commitNowAllowingStateLoss
             */
        }

        (findViewById<TextView>(R.id.tv_detach)).setOnClickListener {
            Log.d("FragmentActivity", "click detach")


            val transaction = fragmentManager.beginTransaction() // 작업의 시작. 새로 만들어서 써라.

            transaction.remove(fragment1)

            transaction.commit() // 여기까지 작업 커밋해라

        }


        (findViewById<TextView>(R.id.tv_accessFragment)).setOnClickListener {
            Log.d("FragmentActivity", "click tv_accessFragment")

            // xml에 있는 fragment를 찾는 방법 ==> FragmentContainerView 의 ID
            val fragment1ById = supportFragmentManager.findFragmentById(R.id.fragment1) as Fragment1
            fragment1ById.doLog("ID기반 조회")


            // xml에 없는 fragment를 찾는 방법 ==> TAG로 구분
            // 없을 때는 NullPointerException 오류남. ==> null 처리 해야함.
            val fragment1ByTag =
                supportFragmentManager.findFragmentByTag("fragment1_tag1") as Fragment1
            fragment1ByTag.doLog("태그기반 조회")

        }

    }


    fun doLog(msg: String) {
        Log.d(TAG, "doLog: $msg")
    }


    companion object {
        private const val TAG = "FragmentActivity"
    }
}