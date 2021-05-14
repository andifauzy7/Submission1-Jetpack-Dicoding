package com.example.moviecatalogue.ui.detail

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.example.moviecatalogue.R
import com.example.moviecatalogue.repository.DataDummy
import com.example.moviecatalogue.ui.main.MainActivity
import org.junit.Rule
import org.junit.Test

class DetailActivityTest {
    private val dummyMovies = DataDummy.generateDummyContentMovies()
    private val dummyShow = DataDummy.generateDummyContentShow()

    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun loadDetailShow() {
        Espresso.onView(ViewMatchers.withContentDescription(R.string.show)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.rv_show)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, ViewActions.click()))
        Espresso.onView(ViewMatchers.withId(R.id.tv_judul_detail)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.tv_judul_detail)).check(ViewAssertions.matches(ViewMatchers.withText(dummyShow[0].name)))
        Espresso.onView(ViewMatchers.withId(R.id.tv_rating_detail)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.tv_rating_detail)).check(ViewAssertions.matches(ViewMatchers.withText(dummyShow[0].score.toString())))
        Espresso.onView(ViewMatchers.withId(R.id.tv_category_detail)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.tv_category_detail)).check(ViewAssertions.matches(ViewMatchers.withText(dummyShow[0].category)))
        Espresso.onView(ViewMatchers.withId(R.id.tv_overview_detail)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.tv_overview_detail)).check(ViewAssertions.matches(ViewMatchers.withText(dummyShow[0].overview)))
    }

    @Test
    fun loadDetailMovies() {
        Espresso.onView(ViewMatchers.withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, ViewActions.click()))
        Espresso.onView(ViewMatchers.withId(R.id.tv_judul_detail)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.tv_judul_detail)).check(ViewAssertions.matches(ViewMatchers.withText(dummyMovies[0].name)))
        Espresso.onView(ViewMatchers.withId(R.id.tv_rating_detail)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.tv_rating_detail)).check(ViewAssertions.matches(ViewMatchers.withText(dummyMovies[0].score.toString())))
        Espresso.onView(ViewMatchers.withId(R.id.tv_category_detail)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.tv_category_detail)).check(ViewAssertions.matches(ViewMatchers.withText(dummyMovies[0].category)))
        Espresso.onView(ViewMatchers.withId(R.id.tv_overview_detail)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.tv_overview_detail)).check(ViewAssertions.matches(ViewMatchers.withText(dummyMovies[0].overview)))
    }
}