package com.example.android

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.Button
import android.widget.EditText


class MainActivity : AppCompatActivity(), View.OnClickListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val v = findViewById<Button>(R.id.button4)
        v.setOnClickListener(this)
    }

    /** Called when the user taps the Send button */
    fun sendMessage(view: View) {
        when(view.id){
            R.id.button -> {
                val editText = findViewById<EditText>(R.id.editText)
                val message = editText.text.toString()
                val intent = Intent(this, DisplayMessageActivity::class.java).apply {
                    putExtra(EXTRA_MESSAGE, message)
                }
                startActivity(intent)
            }
            R.id.button4 -> {
                startActivity(Intent(this,testOnClick::class.java))
            }
        }

    }

    override fun onClick(v: View?) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

        when(v?.id){
            R.id.button -> {
                val editText = findViewById<EditText>(R.id.editText)
                val message = editText.text.toString()
                val intent = Intent(this, DisplayMessageActivity::class.java).apply {
                    putExtra(EXTRA_MESSAGE, message)
                }
                startActivity(intent)
            }
            R.id.button4 -> {
                startActivity(Intent(this,testOnClick::class.java))
            }
        }
    }
}
