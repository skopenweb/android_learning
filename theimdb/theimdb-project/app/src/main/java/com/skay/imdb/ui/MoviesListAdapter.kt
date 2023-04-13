package com.skay.imdb.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.skay.imdb.data.model.Movie
import com.skay.imdb.databinding.ItemMovieBinding

class MoviesListAdapter(private var movies: List<Movie>, private val movieClickHandler: (movie: Movie) -> Unit) :
    RecyclerView.Adapter<MoviesListAdapter.MovieItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieItemViewHolder {
        val binding = ItemMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieItemViewHolder(binding)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieItemViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    fun setItems(items: List<Movie>) {
        this.movies = items
        notifyDataSetChanged()
    }

    inner class MovieItemViewHolder(private val binding: ItemMovieBinding) :
        ViewHolder(binding.root) {
        fun bind(item: Movie) {
            binding.apply {
                tvName.text = item.name
                tvDescription.text = item.description
                Glide.with(itemView.context).load(item.imageUrl).into(image)
                root.setOnClickListener {
                    movieClickHandler(item)
                }
            }
        }
    }
}