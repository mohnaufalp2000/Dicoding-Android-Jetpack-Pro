package com.naufal.moviepedia.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.naufal.moviepedia.adapter.MovieAdapter
import com.naufal.moviepedia.adapter.TVAdapter
import com.naufal.moviepedia.data.MovieData
import com.naufal.moviepedia.data.TVData
import com.naufal.moviepedia.databinding.FragmentTVShowsBinding
import com.naufal.moviepedia.viewmodel.MovieViewModel
import com.naufal.moviepedia.viewmodel.TVViewModel

class TVShowsFragment : Fragment() {

    private var binding : FragmentTVShowsBinding? = null
    private val adapter = TVAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTVShowsBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(activity != null){
            val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[TVViewModel::class.java]
            val tvShows = viewModel.getTV()
            adapter.setTV(tvShows)

            binding?.apply {
                rvTvShows.setHasFixedSize(true)
                rvTvShows.layoutManager = LinearLayoutManager(context)
                rvTvShows.adapter = adapter
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}