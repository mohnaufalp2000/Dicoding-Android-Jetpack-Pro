package com.naufal.moviepedia.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.StringRes
import com.google.android.material.tabs.TabLayoutMediator
import com.naufal.moviepedia.R
import com.naufal.moviepedia.adapter.TabFavoriteAdapter
import com.naufal.moviepedia.adapter.TabMainAdapter
import com.naufal.moviepedia.databinding.ActivityFavoriteBinding

class FavoriteActivity : AppCompatActivity() {

    private val binding by lazy{ActivityFavoriteBinding.inflate(layoutInflater)}

    companion object{
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.movies,
            R.string.tv_shows
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val tabs = binding.tabFavorite
        val viewPager = binding.vpFavorite
        viewPager.adapter = TabFavoriteAdapter(this)

        TabLayoutMediator(tabs, viewPager) { tab, position ->
            tab.text = resources.getString(FavoriteActivity.TAB_TITLES[position])
        }.attach()

        binding.tbFavorite.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
        setSupportActionBar(binding.tbFavorite)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.tbFavorite.setNavigationOnClickListener {
            finish()
        }
    }
}