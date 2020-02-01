package com.example.android

import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_display_message.*


class DisplayMessageActivity : AppCompatActivity() {

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

        onClickSwitch( findViewById<TextView>(R.id.switch1))
    }

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
