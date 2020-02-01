package com.example.android

import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.util.Log
import android.view.View
import android.widget.Switch
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_display_message.*

// 방법2 View.OnClickListener 추가
class DisplayMessageActivity : AppCompatActivity() ,View.OnClickListener{

    //var rSwitch=0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message)

        // Get the Intent that started this activity and extract the string
        val message = intent.getStringExtra(EXTRA_MESSAGE)

        // Capture the layout's TextView and set the string as its text
        val textView = findViewById<TextView>(R.id.textView).apply {
            text = message
        }

        // 방법2
        val v = findViewById<Switch>(R.id.switch2)
        v.setOnClickListener(this)

        // 방법3
        onClickSwitch( findViewById<TextView>(R.id.switch1))
    }

    // 방법2
    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.switch2 -> {
                when (switch2.isChecked) {
                    true -> {
                        imageView2.visibility = View.VISIBLE
                    }
                    false -> {
                        imageView2.visibility = View.INVISIBLE
                    }
                }
                Log.d("trip_", "iv click")
            }
        }
    }

    // 방법3
    fun onClickSwitch(v:View) {
        when (switch1.isChecked) {
            true -> {
                imageView2.visibility = View.VISIBLE
            }
            false -> {
                imageView2.visibility = View.INVISIBLE
            }
        }
    }
}
