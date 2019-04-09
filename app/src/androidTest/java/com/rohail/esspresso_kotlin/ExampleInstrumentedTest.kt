package com.rohail.esspresso_kotlin

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule
import java.text.DecimalFormat

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    val activity = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testAdd() {
        onView(withId(R.id.button_1)).perform(click())
        onView(withId(R.id.button_2)).perform(click())
        onView(withId(R.id.button_3)).perform(click())
        onView(withId(R.id.button_add)).perform(click())
        onView(withId(R.id.button_3)).perform(click())
        onView(withId(R.id.button_2)).perform(click())
        onView(withId(R.id.button_1)).perform(click())
        onView(withId(R.id.button_calc)).perform(click())
        onView(withId(R.id.field))
            .check(matches(withText("${123 + 321}")))
    }

    @Test
    fun testSub() {
        onView(withId(R.id.button_9)).perform(click())
        onView(withId(R.id.button_9)).perform(click())
        onView(withId(R.id.button_9)).perform(click())
        onView(withId(R.id.button_sub)).perform(click())
        onView(withId(R.id.button_3)).perform(click())
        onView(withId(R.id.button_3)).perform(click())
        onView(withId(R.id.button_3)).perform(click())
        onView(withId(R.id.button_calc)).perform(click())
        onView(withId(R.id.field))
            .check(matches(withText("${999 - 333}")))
    }

    @Test
    fun testMulti() {
        onView(withId(R.id.button_1)).perform(click())
        onView(withId(R.id.button_0)).perform(click())
        onView(withId(R.id.button_0)).perform(click())
        onView(withId(R.id.button_multi)).perform(click())
        onView(withId(R.id.button_7)).perform(click())
        onView(withId(R.id.button_0)).perform(click())
        onView(withId(R.id.button_0)).perform(click())
        onView(withId(R.id.button_calc)).perform(click())
        val formatter = DecimalFormat("#,###")
        onView(withId(R.id.field))
            .check(matches(withText(formatter.format(100 * 700))))
    }

    @Test
    fun testDiv() {
        onView(withId(R.id.button_3)).perform(click())
        onView(withId(R.id.button_3)).perform(click())
        onView(withId(R.id.button_3)).perform(click())
        onView(withId(R.id.button_divide)).perform(click())
        onView(withId(R.id.button_1)).perform(click())
        onView(withId(R.id.button_0)).perform(click())
        onView(withId(R.id.button_0)).perform(click())
        onView(withId(R.id.button_calc)).perform(click())
        onView(withId(R.id.field))
            .check(matches(withText("${333 / 100.0}")))
    }
}
