package ru.easycode.zerotoheroandroidtdd


import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import com.google.android.material.textfield.TextInputEditText
import org.hamcrest.CoreMatchers.allOf

class EditNotePage {

    private val rootId: Int = R.id.editNoteRootLayout

    private val inputView = onView(
        allOf(
            isAssignableFrom(TextInputEditText::class.java),
            withId(R.id.noteEditText),
            withParent(isAssignableFrom(LinearLayout::class.java)),
            withParent(withId(rootId))
        )
    )

    fun checkVisibleNow(text: String) {
        onView(
            allOf(
                isAssignableFrom(TextView::class.java),
                withId(R.id.editNoteTitleTextView),
                withText("rename note"),
                withParent(isAssignableFrom(LinearLayout::class.java)),
                withParent(withId(rootId))
            )
        ).check(matches(isDisplayed()))
        inputView.check(matches(withText(text)))
    }

    fun replaceText(text: String) {
        inputView.perform(clearText(), typeText(text))
    }

    fun clickSaveButton() {
        onView(
            allOf(
                withParent(isAssignableFrom(LinearLayout::class.java)),
                withParent(withId(rootId)),
                isAssignableFrom(Button::class.java),
                withId(R.id.saveNoteButton),
                withText("save")
            )
        ).perform(click())
    }

    fun checkNotVisibleNow() {
        inputView.check(doesNotExist())
    }

    fun clickDeleteButton() {
        onView(
            allOf(
                withParent(isAssignableFrom(LinearLayout::class.java)),
                withParent(withId(rootId)),
                isAssignableFrom(Button::class.java),
                withId(R.id.deleteNoteButton),
                withText("delete")
            )
        ).perform(click())
    }
}