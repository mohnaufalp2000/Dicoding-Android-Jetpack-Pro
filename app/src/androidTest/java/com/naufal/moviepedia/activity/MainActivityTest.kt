package com.naufal.moviepedia.activity

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.swipeUp
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.naufal.moviepedia.R
import com.naufal.moviepedia.data.MovieData
import com.naufal.moviepedia.data.TVData
import org.junit.Rule
import org.junit.Test

class MainActivityTest{

    private val dummyMovie = MovieData.getDataMovies()
    private val dummyTV = TVData.getDataTV()

    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun loadMovies(){
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
        onView(withId(R.id.rv_movies)).perform(swipeUp())
    }

    @Test
    fun loadDetailMovies(){
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.detail_activity)).perform(swipeUp())
        onView(withId(R.id.txt_title)).check(matches(isDisplayed()))
        onView(withId(R.id.txt_title)).check(matches(withText(dummyMovie[0].title)))
        onView(withId(R.id.txt_released)).check(matches(isDisplayed()))
        onView(withId(R.id.txt_released)).check(matches(withText(dummyMovie[0].released)))
        onView(withId(R.id.txt_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.txt_genre)).check(matches(withText(dummyMovie[0].genre)))
        onView(withId(R.id.txt_runtime)).check(matches(isDisplayed()))
        onView(withId(R.id.txt_runtime)).check(matches(withText(dummyMovie[0].runtime)))
        onView(withId(R.id.txt_language)).check(matches(isDisplayed()))
        onView(withId(R.id.txt_language)).check(matches(withText(dummyMovie[0].language)))
        onView(withId(R.id.txt_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.txt_rating)).check(matches(withText(dummyMovie[0].rating.toString())))
        onView(withId(R.id.txt_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.txt_overview)).check(matches(withText(dummyMovie[0].overview)))
        onView(withId(R.id.img_poster)).check(matches(isDisplayed()))
    }

    @Test
    fun loadTV(){
        onView(withText("TV SHOWS")).perform(click())
        onView(withId(R.id.rv_tv_shows)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_shows)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTV.size))
        onView(withId(R.id.rv_tv_shows)).perform(swipeUp())
    }

    @Test
    fun loadDetailTV(){
        onView(withText("TV SHOWS")).perform(click())
        onView(withId(R.id.rv_tv_shows)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.detail_activity)).perform(swipeUp())
        onView(withId(R.id.txt_title)).check(matches(isDisplayed()))
        onView(withId(R.id.txt_title)).check(matches(withText(dummyTV[0].title)))
        onView(withId(R.id.txt_released)).check(matches(isDisplayed()))
        onView(withId(R.id.txt_released)).check(matches(withText(dummyTV[0].released)))
        onView(withId(R.id.txt_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.txt_genre)).check(matches(withText(dummyTV[0].genre)))
        onView(withId(R.id.txt_runtime)).check(matches(isDisplayed()))
        onView(withId(R.id.txt_runtime)).check(matches(withText(dummyTV[0].runtime)))
        onView(withId(R.id.txt_language)).check(matches(isDisplayed()))
        onView(withId(R.id.txt_language)).check(matches(withText(dummyTV[0].language)))
        onView(withId(R.id.txt_rating)).check(matches(isDisplayed()))
        onView(withId(R.id.txt_rating)).check(matches(withText(dummyTV[0].rating.toString())))
        onView(withId(R.id.txt_overview)).check(matches(isDisplayed()))
        onView(withId(R.id.txt_overview)).check(matches(withText(dummyTV[0].overview)))
        onView(withId(R.id.img_poster)).check(matches(isDisplayed()))
    }


}