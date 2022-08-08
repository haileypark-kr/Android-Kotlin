package com.example.fastcampuskotlin

import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AsyncActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async)


        (findViewById<TextView>(R.id.tv_log)).setOnClickListener {
            Log.d("AsyncActivity", "logging")
        }

        val asyncTask = BackgroundAsyncTask(
            findViewById<ProgressBar>(R.id.progressBar1),
            findViewById<TextView>(R.id.tv_progress)
        )
        (findViewById<TextView>(R.id.tv_start)).setOnClickListener {
            asyncTask.execute()
        }

        (findViewById<TextView>(R.id.tv_stop)).setOnClickListener {
            asyncTask.cancel(true)
        }
    }


}


class BackgroundAsyncTask(
    val progressBar: ProgressBar, val progressText: TextView
) : AsyncTask<Int, Int, Int>() {

    // deprecated 됨.. ==> 이거 대신 사용해야 하는 I/F를 제공하지 않았음. RXJava나 coroutine 사용
    // coroutine : 멀티태스킹, 비동기 등의 기능 모아둠.


    /*
    AsyncTask<Params, Progress, Result>
    - Params: doInBackground 에서 사용
    - Progress: onProgressUpdate 에서 사용
    - Result: onPostExecute 에서 사용
     */

    var percent: Int = 0

    override fun doInBackground(vararg p0: Int?): Int {
        while (!isCancelled && percent < 100) {
            percent++
            Thread.sleep(10)
            publishProgress(percent) // 진행도 업데이트. 업데이트하고 나면 onProgressUpdate 실행됨.
        }

        return percent
    }

    override fun onPreExecute() {
        percent = 0
        progressBar.progress = percent
    }

    // 비동기 작업 완료 후
    override fun onPostExecute(result: Int?) {
        progressText.text = "작업이 완료되었습니다."
    }

    override fun onCancelled() {
//        progressBar.progress = 0
        progressText.text = "작업이 취소되었습니다."
    }

    override fun onProgressUpdate(vararg values: Int?) {
        val updatedPercent = values[0] ?: 0
        progressBar.progress = updatedPercent
        progressText.text = "$updatedPercent%"

        Log.d("BackgroundAsyncTask", "onProgressUpdate")
    }
}