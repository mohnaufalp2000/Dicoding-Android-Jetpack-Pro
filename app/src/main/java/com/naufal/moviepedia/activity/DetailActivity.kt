package com.naufal.moviepedia.activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.naufal.moviepedia.R
import com.naufal.moviepedia.databinding.ActivityDetailBinding
import com.naufal.moviepedia.model.*
import com.naufal.moviepedia.util.Constant.Companion.IMG_URL
import com.naufal.moviepedia.viewmodel.DetailViewModel
import com.naufal.moviepedia.viewmodel.ViewModelFactory
import com.naufal.moviepedia.vo.Status

class DetailActivity : AppCompatActivity() {

    private val binding by lazy {ActivityDetailBinding.inflate(layoutInflater)}
    private lateinit var mDetailViewModel: DetailViewModel
    private var stateMovie: Boolean? = false
    private var stateTV: Boolean? = false

    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val factory = ViewModelFactory.getInstance(this)
        mDetailViewModel = ViewModelProvider(this, factory).get(DetailViewModel::class.java)

        setupToolbar()

        val extras = intent.extras
        if (extras!=null){
            val idMovie = intent.getIntExtra(EXTRA_MOVIE, 0)
            val idShow = intent.getIntExtra(EXTRA_TV, 0)

            mDetailViewModel.setSelectedMovie(idMovie)
            mDetailViewModel.setSelectedTV(idShow)

            when(intent.getIntExtra(EXTRA_TYPE, 0)){
                0 -> {
                    mDetailViewModel.getDetailMovie(this).observe(this, { detail ->
                        if (detail != null){
                            when(detail.status){
                                Status.LOADING -> binding.pbDetail.visibility = View.VISIBLE
                                Status.SUCCESS -> if (detail.data != null){
                                    loadingIndicator(false)
                                    stateMovie = detail.data.isFavorite
                                    populateMovie(detail.data)
                                    addToFavoriteMovie(detail.data)
                                }
                                Status.ERROR -> {
                                    loadingIndicator(false)
                                    Toast.makeText(this, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                                }
                            }
                        }

                    })
                }
                1 -> {
                    mDetailViewModel.getDetailTV(this).observe(this, { detail ->
                        if (detail != null){
                            when(detail.status){
                                Status.LOADING -> binding.pbDetail.visibility = View.VISIBLE
                                Status.SUCCESS -> if (detail.data != null){
                                    loadingIndicator(false)
                                    stateTV = detail.data.isFavorite
                                    populateTV(detail.data)
                                    addToFavoriteTV(detail.data)
                                }
                                Status.ERROR -> {
                                    loadingIndicator(false)
                                    Toast.makeText(this, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                                }
                            }
                        }
                    })
                }
            }
        }
    }

    private fun addToFavoriteMovie(detail: MovieEntity?) {
        binding.btnFavorite.setOnClickListener {
            stateMovie = !stateMovie!!
            if (stateMovie as Boolean){
                binding.btnFavorite.setImageResource(R.drawable.ic_baseline_favorite_24)
            } else {
                binding.btnFavorite.setImageResource(R.drawable.ic_baseline_favorite_border_24)
            }
            detail?.let { favorite -> mDetailViewModel.setFavoriteMovies(favorite, stateMovie!!) }
        }
    }

    private fun addToFavoriteTV(data: TVEntity?) {
        binding.btnFavorite.setOnClickListener {
            stateTV = !stateTV!!
            if (stateTV as Boolean){
                binding.btnFavorite.setImageResource(R.drawable.ic_baseline_favorite_24)
            } else {
                binding.btnFavorite.setImageResource(R.drawable.ic_baseline_favorite_border_24)
            }
            data?.let { favorite -> mDetailViewModel.setFavoriteTV(favorite, stateTV!!) }
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

    private fun populateMovie(movies: MovieEntity?) {
        loadingIndicator(true)
        binding.apply {
            txtTitle.text = movies?.title
            txtRating.text = movies?.voteAverage.toString()
            txtOverview.text = movies?.overview
            txtLanguage.text = movies?.originalLanguage
            txtRuntime.text = movies?.runtime.toString()
            txtReleased.text = movies?.releaseDate?.subSequence(0,4)
//            txtGenre.text = movies?.genres?.component1()?.component1()
            txtRuntimeHours.visibility = View.VISIBLE

            checkFavState(stateMovie)

            Glide.with(this@DetailActivity)
                .load("$IMG_URL${movies?.posterPath}")
                .into(imgPoster)
        }

    }

    private fun populateTV(tv: TVEntity?) {
        loadingIndicator(true)
        binding.apply {
            txtTitle.text = tv?.name
            txtRating.text = tv?.voteAverage.toString()
            txtOverview.text = tv?.overview
            txtLanguage.text = tv?.originalLanguage
//            txtGenre.text = tv?.genres?.component1()?.component1()
//            if (tv?.episodeRunTime?.size != 0){
//                if (tv != null) {
//                    txtRuntime.text = tv.episodeRunTime?.get(0).toString()
//                }
//            } else {
//                txtRuntime.text = 0.toString()
//            }
            txtReleased.text = tv?.firstAirDate?.subSequence(0,4)

            checkFavState(stateTV)

            Glide.with(this@DetailActivity)
                .load("$IMG_URL${tv?.posterPath}")
                .into(imgPoster)
        }

    }

    private fun checkFavState(state: Boolean?) {
        if (state == true){
            binding.btnFavorite.setImageResource(R.drawable.ic_baseline_favorite_24)
        } else {
            binding.btnFavorite.setImageResource(R.drawable.ic_baseline_favorite_border_24)
        }
    }

    private fun loadingIndicator(indicator: Boolean) {
        if (indicator){
            binding.apply {
                pbDetail.visibility = View.GONE
                appbarDetail.visibility = View.VISIBLE
                detailScroll.visibility = View.VISIBLE
                btnFavorite.visibility = View.VISIBLE
            }
        } else {
            binding.apply {
                pbDetail.visibility = View.VISIBLE
                appbarDetail.visibility = View.GONE
                detailScroll.visibility = View.GONE
                btnFavorite.visibility = View.GONE
            }
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