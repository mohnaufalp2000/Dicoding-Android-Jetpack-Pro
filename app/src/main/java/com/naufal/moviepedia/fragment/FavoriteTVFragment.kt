package com.naufal.moviepedia.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.naufal.moviepedia.adapter.FavoriteTVAdapter
import com.naufal.moviepedia.databinding.FragmentFavoriteTVBinding
import com.naufal.moviepedia.viewmodel.FavTVViewModel
import com.naufal.moviepedia.viewmodel.ViewModelFactory

class FavoriteTVFragment : Fragment() {

    private var binding : FragmentFavoriteTVBinding? = null
    private val adapterTV = FavoriteTVAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFavoriteTVBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val factory = ViewModelFactory.getInstance(context)
        val mFavTVViewModel by lazy {
            ViewModelProvider(this, factory).get(FavTVViewModel::class.java)
        }

        mFavTVViewModel.getFavoriteTV(context).observe(viewLifecycleOwner, {
            adapterTV.setTV(it)
            showRecyclerView()
        })

    }

    private fun showRecyclerView() {
        binding?.rvFavoriteTv?.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            adapter = adapterTV
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}