package org.d3ifcool.MySkin

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest{

    @Test
    fun testTips() {
        //Jalankan Mainactivity
        val activityScenario = ActivityScenario.launch(
            MainActivity::class.java
        )
        //lakukan aksi
        onView(withId(R.id.button2)).perform(click())

        //cek hasil
        onView(withId(R.id.judul_tips)).check(matches(isDisplayed()))
        onView(withId(R.id.gambartips)).check(matches(isDisplayed()))
        onView(withId(R.id.text_tips)).check(matches(isDisplayed()))
        onView(withId(R.id.judul_tricks)).check(matches(isDisplayed()))
        onView(withId(R.id.gambartricks)).check(matches(isDisplayed()))
        onView(withId(R.id.text_tricks)).check(matches(isDisplayed()))
        onView(withId(R.id.judulKusam)).check(matches(isDisplayed()))
        onView(withId(R.id.gambarkusam)).check(matches(isDisplayed()))


        //tes selesai
        activityScenario.close()
    }

    @Test
    fun video() {
        //Jalankan Mainactivity
        val activityScenario = ActivityScenario.launch(
            MainActivity::class.java
        )

        //lakukan aksi
        onView(withId(R.id.button4)).perform(click())

        //cek hasil
        onView(withId(R.id.video1)).check(matches(isDisplayed()))
        onView(withId(R.id.video2)).check(matches(isDisplayed()))
        onView(withId(R.id.video3)).check(matches(isDisplayed()))

        //tes selesai
        activityScenario.close()
    }
}