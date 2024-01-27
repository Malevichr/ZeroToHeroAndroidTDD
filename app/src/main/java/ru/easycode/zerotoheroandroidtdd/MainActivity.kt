package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.hideButton)
        textView = findViewById(R.id.titleTextView)

        button.setOnClickListener {
            textView.visibility = View.INVISIBLE
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("keyText", textView.text.toString())
        outState.putString("keyVisibility", textView.visibility.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        textView.text = savedInstanceState.getString("keyText")
        if(savedInstanceState.getString("keyVisibility") == View.INVISIBLE.toString()){
            textView.visibility = View.INVISIBLE
        }

    }

    override fun onDestroy() {
        super.onDestroy()
    }

}