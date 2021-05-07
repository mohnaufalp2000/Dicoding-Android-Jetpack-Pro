package com.naufal.moviepedia.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.naufal.moviepedia.R
import com.naufal.moviepedia.databinding.ActivityDetailBinding
import com.naufal.moviepedia.model.DetailMovieResponse
import com.naufal.moviepedia.model.DetailTVResponse
import com.naufal.moviepedia.util.Constant.Companion.IMG_URL
import com.naufal.moviepedia.viewmodel.DetailViewModel

import com.naufal.moviepedia.viewmodel.MovieViewModel
import com.naufal.moviepedia.viewmodel.ViewModelFactory

class DetailActivity : AppCompatActivity() {

    private val binding by lazy {ActivityDetailBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupToolbar()

        val factory = ViewModelFactory.getInstance()
        val mDetailViewModel by lazy { ViewModelProvider(this, factory).get(DetailViewModel::class.java) }

        val extras = intent.extras

        if (extras!=null){
            val idMovie = intent.getIntExtra(EXTRA_MOVIE, 0)
            val idShow = intent.getIntExtra(EXTRA_TV, 0)

            when(intent.getIntExtra(EXTRA_TYPE, 0)){
                0 -> {
                    mDetailViewModel.getDetailMovie(idMovie).observe(this, { detail ->
                        populateMovie(detail)
                    })
                }
                1 -> {
                    mDetailViewModel.getDetailShow(idShow).observe(this, { detail ->
                        populateShow(detail)
                    })
                }
            }

        }

    }

    private fun setupToolbar() {
        setSupportActionBar(binding.tbDetail)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.tbDetail.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
        binding.tbDetail.setNavigationOnClickListener {
            finish()
        }
    }

    private fun populateShow(tv: DetailTVResponse?) {
        binding.apply {
            txtTitle.text = tv?.name
            txtRating.text = tv?.voteAverage.toString()
            txtOverview.text = tv?.overview
            txtLanguage.text = tv?.originalLanguage

            Glide.with(this@DetailActivity)
                .load("$IMG_URL${tv?.posterPath}")
                .into(imgPoster)
        }

    }

    private fun populateMovie(movies: DetailMovieResponse?) {
        binding.apply {
            txtTitle.text = movies?.title
            txtRating.text = movies?.voteAverage.toString()
            txtOverview.text = movies?.overview
            txtLanguage.text = movies?.originalLanguage

            Glide.with(this@DetailActivity)
                .load("$IMG_URL${movies?.posterPath}")
                .into(imgPoster)
        }

    }

    companion object{
        const val EXTRA_TV = "tv"
        const val EXTRA_MOVIE = "movie"
        const val EXTRA_TYPE = "extraType"
        const val TYPE_MOVIE = 0
        const val TYPE_TV = 1
    }

}