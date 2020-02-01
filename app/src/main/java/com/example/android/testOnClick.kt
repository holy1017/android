package com.example.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_test_on_click.*
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.actor

class testOnClick : AppCompatActivity() {

    private var count2 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_on_click)

        // 다중 실행
        var count = 0
        button2.setOnClickListener {
            count++
            CoroutineScope(Dispatchers.Main).launch {
                for (i in 10 downTo 1) { // countdown from 10 to 1
                    textView3.text = "Now Click $count Countdown $i ..." // update text
                    delay(500) // wait half a second
                }
                textView3.text = "Done!"
            }
        }

        // 실행동안 대기
        button3.onClick {
            count2++
            for (i in 10 downTo 1) { // countdown from 10 to 1
                textView4.text = "Now Click $count2 Countdown $i ..." // update text
                delay(500) // wait half a second
            }
            textView4.text = "Done!"
        }

    }

    // 실행동안 대기
    private fun View.onClick(action: suspend (View) -> Unit) {
        // launch one actor
        val event = GlobalScope.actor<View>(Dispatchers.Main) {
            for (event in channel) action(event)
        }

        setOnClickListener {
            event.offer(it)
        }
    }

}
