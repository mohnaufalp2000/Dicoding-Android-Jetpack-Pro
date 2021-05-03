package com.naufal.moviepedia.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.naufal.moviepedia.adapter.MovieAdapter
import com.naufal.moviepedia.data.MovieData
import com.naufal.moviepedia.databinding.FragmentMoviesBinding
import com.naufal.moviepedia.viewmodel.MovieViewModel

class MoviesFragment : Fragment() {

    private var binding : FragmentMoviesBinding? = null
    private val adapter = MovieAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMoviesBinding.inflate(inflater, container, false)
        return binding?.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(activity != null){
            val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[MovieViewModel::class.java]
            val movies = viewModel.getMovies()
            adapter.setMovies(movies)

            binding?.apply {
                rvMovies.setHasFixedSize(true)
                rvMovies.layoutManager = LinearLayoutManager(context)
                rvMovies.adapter = adapter
            }
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}