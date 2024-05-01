package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val textView: TextView = findViewById(R.id.titleTextView)
        val button: Button = findViewById(R.id.actionButton)

        button.setOnClickListener{
            progressBar.visibility = View.VISIBLE
            button.isEnabled = false
            Thread{
                Thread.sleep(1000)
                runOnUiThread{
                    textView.visibility = View.VISIBLE
                    progressBar.visibility = View.INVISIBLE
                    button.isEnabled = true
                }
            }.start()


        }
    }

}