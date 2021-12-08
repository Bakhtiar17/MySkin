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

    @Test
    fun jenis() {
        //Jalankan Mainactivity
        val activityScenario = ActivityScenario.launch(
            MainActivity::class.java
        )

        //lakukan aksi
        onView(withId(R.id.button0)).perform(click())

        //cek hasil
        onView(withId(R.id.judul_test)).check(matches(isDisplayed()))
        onView(withId(R.id.imageView)).check(matches(isDisplayed()))
        onView(withId(R.id.soal)).check(matches(isDisplayed()))
        onView(withId(R.id.text1)).check(matches(isDisplayed()))
        onView(withId(R.id.text2)).check(matches(isDisplayed()))
        onView(withId(R.id.text3)).check(matches(isDisplayed()))

        //tes selesai
        activityScenario.close()
    }

    @Test
    fun kulit() {
        //Jalankan Mainactivity
        val activityScenario = ActivityScenario.launch(
            MainActivity::class.java
        )

        //lakukan aksi
        onView(withId(R.id.button)).perform(click())


        //cek hasil
        onView(withId(R.id.imageView)).check(matches(isDisplayed()))
        onView(withId(R.id.judulMasalah)).check(matches(isDisplayed()))
        onView(withId(R.id.img1)).check(matches(isDisplayed()))
        onView(withId(R.id.img2)).check(matches(isDisplayed()))
        onView(withId(R.id.img3)).check(matches(isDisplayed()))
        onView(withId(R.id.img4)).check(matches(isDisplayed()))

        //tes selesai
        activityScenario.close()
    }

    @Test
    fun kusam() {
        //Jalankan Mainactivity
        val activityScenario = ActivityScenario.launch(
            MainActivity::class.java
        )

        //lakukan aksi
        onView(withId(R.id.button)).perform(click())
        onView(withId(R.id.but1)).perform(click())

        //cek hasil
        onView(withId(R.id.imageView)).check(matches(isDisplayed()))
        onView(withId(R.id.judulKusam)).check(matches(isDisplayed()))
        onView(withId(R.id.textKusam)).check(matches(isDisplayed()))

        //tes selesai
        activityScenario.close()
    }

    @Test
    fun jerawat() {
        //Jalankan Mainactivity
        val activityScenario = ActivityScenario.launch(
            MainActivity::class.java
        )

        //lakukan aksi
        onView(withId(R.id.button)).perform(click())
        onView(withId(R.id.but2)).perform(click())

        //cek hasil
        onView(withId(R.id.imageView)).check(matches(isDisplayed()))
        onView(withId(R.id.judulJerawat)).check(matches(isDisplayed()))
        onView(withId(R.id.textJerawat)).check(matches(isDisplayed()))

        //tes selesai
        activityScenario.close()
    }

    @Test
    fun flek() {
        //Jalankan Mainactivity
        val activityScenario = ActivityScenario.launch(
            MainActivity::class.java
        )

        //lakukan aksi
        onView(withId(R.id.button)).perform(click())
        onView(withId(R.id.but3)).perform(click())

        //cek hasil
        onView(withId(R.id.imageView)).check(matches(isDisplayed()))
        onView(withId(R.id.judulFlek)).check(matches(isDisplayed()))
        onView(withId(R.id.textFlek)).check(matches(isDisplayed()))

        //tes selesai
        activityScenario.close()
    }

    @Test
    fun keriput() {
        //Jalankan Mainactivity
        val activityScenario = ActivityScenario.launch(
            MainActivity::class.java
        )

        //lakukan aksi
        onView(withId(R.id.button)).perform(click())
        onView(withId(R.id.but4)).perform(click())

        //cek hasil
        onView(withId(R.id.imageView)).check(matches(isDisplayed()))
        onView(withId(R.id.judulKeriput)).check(matches(isDisplayed()))
        onView(withId(R.id.textKeriput)).check(matches(isDisplayed()))

        //tes selesai
        activityScenario.close()
    }

}