package ru.easycode.zerotoheroandroidtdd

import android.opengl.Visibility
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var textView: TextView
    lateinit var layout: LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById<TextView>(R.id.titleTextView)
        val removeButton = findViewById<Button>(R.id.removeButton)
        layout = findViewById<LinearLayout>(R.id.rootLayout)



        removeButton.setOnClickListener{
            layout.removeView(textView)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {

        super.onSaveInstanceState(outState)
        val isRemoved: Boolean = layout.indexOfChild(textView) == -1
        outState.putBoolean("removed", isRemoved)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState.getBoolean("removed")){
            layout.removeView(textView)
        }
    }
}