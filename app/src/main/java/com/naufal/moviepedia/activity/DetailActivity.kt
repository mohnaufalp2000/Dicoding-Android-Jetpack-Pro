package com.naufal.moviepedia.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.naufal.moviepedia.R
import com.naufal.moviepedia.databinding.ActivityDetailBinding
import com.naufal.moviepedia.model.Movie
import com.naufal.moviepedia.model.TV
import com.naufal.moviepedia.viewmodel.DetailViewModel

class DetailActivity : AppCompatActivity() {

    private val binding by lazy {ActivityDetailBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupToolbar()

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailViewModel::class.java]

        val extras = intent.extras
        if (extras!=null){
            val movieId = intent.getStringExtra(EXTRA_MOVIE)
            val tvId = intent.getStringExtra(EXTRA_TV)

            if (movieId!=null){
                viewModel.setSelectedMovie(movieId)
                populateMovie(viewModel.getMovie())
            }

            if (tvId!=null){
                viewModel.setSelectedTV(tvId)
                populateTV(viewModel.getTV())
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

    private fun populateTV(tv: TV) {

        binding.apply {
            txtTitle.text = tv.title
            txtGenre.text = tv.genre
            txtRating.text = tv.rating.toString()
            txtOverview.text = tv.overview
            txtReleased.text = tv.released
            txtRuntime.text = tv.runtime
            txtLanguage.text = tv.language

            Glide.with(this@DetailActivity)
                .load(tv.img)
                .into(imgPoster)
        }

    }

    private fun populateMovie(movies: Movie) {

        binding.apply {
            txtTitle.text = movies.title
            txtGenre.text = movies.genre
            txtRating.text = movies.rating.toString()
            txtOverview.text = movies.overview
            txtReleased.text = movies.released
            txtRuntime.text = movies.runtime
            txtLanguage.text = movies.language

            Glide.with(this@DetailActivity)
                .load(movies.img)
                .into(imgPoster)
        }

    }

    companion object{
        const val EXTRA_TV = "tv"
        const val EXTRA_MOVIE = "movie"
    }

}