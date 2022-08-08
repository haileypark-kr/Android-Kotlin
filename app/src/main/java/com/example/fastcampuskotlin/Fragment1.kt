package com.example.fastcampuskotlin

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class Fragment1 : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 데이터 받아오기
        val string: String? = arguments?.getString("key")
        Log.d("Fragment1", "data : $string")
    }

    /**
     *  @param inflater XML을 화면에 사용할 준비하기 위해 필요. xml을 view로 만들어줌
     *  @param container fragment에서 사용할 XML의 부모 view
     *  @param savedInstanceState 사용자 앱 사용 기록 등
     *  @return View? fragment에서 사용할 XML
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // container의 자식 뷰로 fragment를 넣어줌.
        // 세번째 파라미터 attachToRoot: 루트 view에 붙일지말지가 아니라, true면 바로 붙고 false는 때가 되면..=> addView 배우면 나옴

        return inflater.inflate(R.layout.fragment1, container, false)

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        (view.findViewById<TextView>(R.id.tv_callActivity)).setOnClickListener {
            val string: String? = arguments?.getString("key")

            if (string != null) {
                (activity as FragmentActivity).doLog(string)
            }
        }
    }


    fun doLog(msg: String) {
        Log.d(TAG, "doLog: $msg")
    }


    companion object {
        private const val TAG = "Fragment1"
    }
}