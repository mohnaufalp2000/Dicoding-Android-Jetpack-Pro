package com.naufal.moviepedia.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.naufal.moviepedia.fragment.MoviesFragment
import com.naufal.moviepedia.fragment.TVShowsFragment

class TabMainAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {

    private val fragment = arrayOf(
        MoviesFragment(),
        TVShowsFragment()
    )

    override fun getItemCount(): Int = fragment.size

    override fun createFragment(position: Int): Fragment = fragment[position]
}