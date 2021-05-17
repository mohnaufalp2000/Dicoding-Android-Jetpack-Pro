package com.naufal.moviepedia.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.naufal.moviepedia.adapter.FavoriteMovieAdapter
import com.naufal.moviepedia.databinding.FragmentFavoriteMoviesBinding
import com.naufal.moviepedia.viewmodel.DetailViewModel
import com.naufal.moviepedia.viewmodel.ViewModelFactory

class FavoriteMoviesFragment : Fragment() {

    private var binding : FragmentFavoriteMoviesBinding? = null
    private val adapterMovies = FavoriteMovieAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFavoriteMoviesBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val factory = ViewModelFactory.getInstance(context)
        val mDetailMovieViewModel by lazy {
            ViewModelProvider(this, factory).get(DetailViewModel::class.java)
        }

        mDetailMovieViewModel.getFavoriteMovies(context).observe(viewLifecycleOwner, {
            adapterMovies.setMovies(it)
            showRecyclerView()
        })
    }

    private fun showRecyclerView() {
        binding?.rvFavoriteMovie?.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = adapterMovies
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}