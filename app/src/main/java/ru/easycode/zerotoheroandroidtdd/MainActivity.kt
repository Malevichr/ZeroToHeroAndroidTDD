package ru.easycode.zerotoheroandroidtdd

import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.io.Serializable

class MainActivity : AppCompatActivity() {
    private var  state: State = State.Initial
    private lateinit var textView: TextView
    private lateinit var layout: LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.titleTextView)
        val removeButton = findViewById<Button>(R.id.removeButton)
        layout = findViewById(R.id.rootLayout)



        removeButton.setOnClickListener{
            state = State.Removed
            state.apply(layout, textView)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {

        super.onSaveInstanceState(outState)
        outState.putSerializable(KEY, state)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        state = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            savedInstanceState.getSerializable(KEY, State::class.java) as State
        }else{
            savedInstanceState.getSerializable(KEY) as State
        }
        state.apply(layout, textView)
    }
    companion object{
        val KEY:String = "removedKey"
    }
}
interface State: Serializable{
    fun apply(linearLayout: LinearLayout, textView: TextView)
    object Initial: State{
        private fun readResolve(): Any = Initial
        override fun apply(linearLayout: LinearLayout, textView: TextView) = Unit

    }
    object Removed: State{
        private fun readResolve(): Any = Removed
        override fun apply(linearLayout: LinearLayout, textView: TextView) {
            linearLayout.removeView(textView)
        }
    }
}