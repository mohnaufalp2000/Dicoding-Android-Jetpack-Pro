package com.naufal.moviepedia.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.naufal.moviepedia.activity.DetailActivity
import com.naufal.moviepedia.databinding.ListMainBinding
import com.naufal.moviepedia.model.Movie
import com.naufal.moviepedia.model.TV

class TVAdapter : RecyclerView.Adapter<TVAdapter.ViewHolder>() {

    private var list = ArrayList<TV>()

    fun setTV(list : List<TV>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding : ListMainBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tv: TV){
            with(binding){
                txtTitle.text = tv.title
                txtGenre.text = tv.genre
                txtRate.text = tv.rating.toString()
                txtLanguage.text = tv.language

                itemView.setOnClickListener {
                    val intent = Intent(it.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_TV, tv.id)
                    it.context.startActivity(intent)
                }

                Glide.with(itemView.context)
                    .load(tv.img)
                    .into(imgMovie)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ListMainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(this.list[position])
    }

    override fun getItemCount(): Int = this.list.size
}
