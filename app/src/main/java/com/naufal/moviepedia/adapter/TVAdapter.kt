package com.naufal.moviepedia.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.naufal.moviepedia.activity.DetailActivity
import com.naufal.moviepedia.databinding.ListTvBinding
import com.naufal.moviepedia.model.TVEntity
import com.naufal.moviepedia.util.Constant.Companion.IMG_URL

class TVAdapter : PagedListAdapter<TVEntity, TVAdapter.ViewHolder>(DIFF_CALLBACK) {

    companion object{
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TVEntity>(){
            override fun areItemsTheSame(oldItem: TVEntity, newItem: TVEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: TVEntity, newItem: TVEntity): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ListTvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tv = getItem(position)
        if (tv!=null){
            holder.bind(tv)
        }
    }

    class ViewHolder(private val binding : ListTvBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tv: TVEntity){
            with(binding){
                txtTitle.text = tv.name
                txtRate.text = tv.voteAverage.toString()
                txtLanguage.text = tv.originalLanguage

                itemView.setOnClickListener {
                    val intent = Intent(it.context, DetailActivity::class.java)
                    intent.apply {
                        putExtra(DetailActivity.EXTRA_TV, tv.id)
                        putExtra(DetailActivity.EXTRA_TYPE, DetailActivity.TYPE_TV)
                    }
                    it.context.startActivity(intent)
                }

                Glide.with(itemView.context)
                    .load("$IMG_URL${tv.posterPath}")
                    .into(imgMovie)
            }
        }
    }
}
