package com.example.moviecatalogue.ui.movies

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviecatalogue.databinding.ItemMoviesBinding
import com.example.moviecatalogue.model.ContentEntity
import com.example.moviecatalogue.ui.detail.DetailActivity

class MoviesAdapter : RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {
    private var listMovies = ArrayList<ContentEntity>()

    fun setMovies(movies: List<ContentEntity>?){
        if(movies == null) return
        this.listMovies.clear()
        this.listMovies.addAll(movies)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MoviesViewHolder {
        val itemsMoviesBinding = ItemMoviesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoviesViewHolder(itemsMoviesBinding)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movies = listMovies[position]
        holder.bind(movies)
    }

    class MoviesViewHolder(private val binding: ItemMoviesBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movies: ContentEntity) {
            with(binding) {
                tvItemNameMovies.text = movies.name
                tvItemCategoryMovies.text = movies.category
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.ID_CONTENT, movies.id)
                    intent.putExtra(DetailActivity.TYPE_CONTENT, "MOVIES")
                    itemView.context.startActivity(intent)
                }
                Glide.with(itemView.context)
                    .load(movies.image)
                    .into(imgPosterMovies)
            }
        }
    }

    override fun getItemCount(): Int = listMovies.size
}