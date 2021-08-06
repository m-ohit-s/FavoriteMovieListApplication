package com.synergy.movielist.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.synergy.movielist.Database.Movie
import com.synergy.movielist.R

class MovieAdapter(private val context: Context, private val listener: IMovieAdapter): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    private val allMovies = ArrayList<Movie>()
    inner class MovieViewHolder(view: View): RecyclerView.ViewHolder(view){
        val movieID: TextView = view.findViewById(R.id.movie_id)
        val movieName: TextView =view.findViewById(R.id.name)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val adapterLayout = MovieViewHolder(LayoutInflater.from(context).inflate(R.layout.movie_list_item, parent, false))
        adapterLayout.movieName.setOnClickListener{
            listener.onItemClicked(allMovies[adapterLayout.adapterPosition])
        }
        return adapterLayout
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val currentMovie = allMovies[position]
        holder.movieName.text = currentMovie.movieName
        holder.movieID.text = currentMovie.id.toString()
    }

    override fun getItemCount(): Int = allMovies.size

    fun update(newList: List<Movie>){
        allMovies.clear()
        allMovies.addAll(newList)
         notifyDataSetChanged()
    }
}

interface IMovieAdapter{
    fun onItemClicked(movie: Movie)
}