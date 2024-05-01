package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.TextView
import java.io.Serializable

interface UiState : Serializable {
    fun apply(
        textView: TextView,
        button: Button
    )

    abstract class Abstract(protected val text: String) : UiState {
        override fun apply(textView: TextView, button: Button) {
            textView.text = text
        }

        override fun hashCode(): Int {
            return text.hashCode()
        }
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as Abstract

            return text == other.text
        }
    }

    class Base(text: String) : Abstract(text) {
        override fun apply(textView: TextView, button: Button) {
            super.apply(textView, button)
            button.isEnabled = true
        }
    }

    class Max(text: String) : Abstract(text) {
        override fun apply(textView: TextView, button: Button) {
            super.apply(textView, button)
            button.isEnabled = false
        }
    }

    class Empty : UiState {
        override fun apply(textView: TextView, button: Button) = Unit

    }
}