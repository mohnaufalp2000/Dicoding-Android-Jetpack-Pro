package com.naufal.moviepedia.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.naufal.moviepedia.adapter.TVAdapter
import com.naufal.moviepedia.databinding.FragmentTVShowsBinding
import com.naufal.moviepedia.viewmodel.TVViewModel
import com.naufal.moviepedia.viewmodel.ViewModelFactory

class TVShowsFragment : Fragment() {

    private var binding : FragmentTVShowsBinding? = null
    private val adapterShows = TVAdapter()
    private val factory = ViewModelFactory.getInstance()
    private val mTVViewModel by lazy {
        ViewModelProvider(this, factory).get(TVViewModel::class.java)
    }

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

        mTVViewModel.getTV(context).observe(viewLifecycleOwner, { list ->
            list?.let { adapterShows.setTV(it) }
            showRecyclerView()
        })

    }

    private fun showRecyclerView() {
        binding?.rvTvShows?.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = adapterShows
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}