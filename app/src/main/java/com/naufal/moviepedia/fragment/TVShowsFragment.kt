package com.naufal.moviepedia.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.naufal.moviepedia.adapter.TVAdapter
import com.naufal.moviepedia.databinding.FragmentTVShowsBinding
import com.naufal.moviepedia.viewmodel.TVViewModel
import com.naufal.moviepedia.viewmodel.ViewModelFactory
import com.naufal.moviepedia.vo.Status

class TVShowsFragment : Fragment() {

    private var binding : FragmentTVShowsBinding? = null
    private val adapterTV = TVAdapter()


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

        val factory = ViewModelFactory.getInstance(context)
        val mTVViewModel by lazy {
            ViewModelProvider(this, factory).get(TVViewModel::class.java)
        }

        mTVViewModel.getTV(context).observe(viewLifecycleOwner, { list ->
            if (list!=null){
                when(list.status){
                    Status.SUCCESS -> {
                        adapterTV.submitList(list.data)
                    }
                    Status.ERROR -> {
                        Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
        showRecyclerView()
    }

    private fun showRecyclerView() {
        binding?.rvTvShows?.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = adapterTV
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}