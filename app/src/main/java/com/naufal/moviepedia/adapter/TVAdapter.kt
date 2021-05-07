package com.naufal.moviepedia.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.naufal.moviepedia.activity.DetailActivity
import com.naufal.moviepedia.databinding.ListMainBinding
import com.naufal.moviepedia.model.MovieItems
import com.naufal.moviepedia.model.TVItems
import com.naufal.moviepedia.util.Constant.Companion.IMG_URL

class TVAdapter : RecyclerView.Adapter<TVAdapter.ViewHolder>() {

    private var list = ArrayList<TVItems?>()

    fun setTV(list : ArrayList<TVItems?>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding : ListMainBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tv: TVItems){
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ListMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        this.list[position]?.let { holder.bind(it) }
    }

    override fun getItemCount(): Int = this.list.size
}
