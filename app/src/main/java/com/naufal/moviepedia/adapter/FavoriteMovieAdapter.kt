package com.naufal.moviepedia.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.naufal.moviepedia.activity.DetailActivity
import com.naufal.moviepedia.databinding.ListMainBinding
import com.naufal.moviepedia.model.MovieEntity
import com.naufal.moviepedia.model.MovieItems
import com.naufal.moviepedia.util.Constant

class FavoriteMovieAdapter : PagedListAdapter<MovieEntity, FavoriteMovieAdapter.ViewHolder>(DIFF_CALLBACK) {

    companion object{
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieEntity>() {
            override fun areItemsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem == newItem
            }

        }
    }

    private var list = ArrayList<MovieEntity?>()

    fun setMovies(list : List<MovieEntity?>?){
        this.list.clear()
        list?.let { this.list.addAll(it) }
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding : ListMainBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie : MovieEntity){
            with(binding){
                txtTitle.text = movie.title
                txtRate.text = movie.voteAverage.toString()
                txtLanguage.text = movie.originalLanguage

                itemView.setOnClickListener {
                    val intent = Intent(it.context, DetailActivity::class.java)
                    intent.apply {
                        putExtra(DetailActivity.EXTRA_MOVIE, movie.id)
                        putExtra(DetailActivity.EXTRA_TYPE, DetailActivity.TYPE_MOVIE)
                    }
                    it.context.startActivity(intent)
                }

                Glide.with(itemView.context)
                    .load("${Constant.IMG_URL}${movie.posterPath}")
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

    override fun getItemCount() : Int = this.list.size
}