package com.naufal.moviepedia.adapter

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.naufal.moviepedia.fragment.FavoriteMoviesFragment
import com.naufal.moviepedia.fragment.FavoriteTVFragment

class TabFavoriteAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {

    private val fragment = arrayOf(
        FavoriteMoviesFragment(),
        FavoriteTVFragment()
    )

    override fun getItemCount(): Int = fragment.size

    override fun createFragment(position: Int): Fragment = fragment[position]
}