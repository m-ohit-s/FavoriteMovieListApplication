package com.synergy.movielist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.synergy.movielist.Database.Movie
import com.synergy.movielist.adapter.IMovieAdapter
import com.synergy.movielist.adapter.MovieAdapter
import com.synergy.movielist.viewModel.MovieViewModel

class MovieList : AppCompatActivity(), IMovieAdapter {

    lateinit var viewModel: MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = MovieAdapter(this, this)
        recyclerView.adapter = adapter

        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(MovieViewModel::class.java)
        viewModel.allMovies.observe(this, Observer {
            adapter.update(it)
        })
    }

    override fun onItemClicked(movie: Movie) {
        val intent = Intent(this, MovieDetails::class.java)
        intent.putExtra("movie_name", movie.movieName)
        intent.putExtra("actor_name", movie.actorName)
        intent.putExtra("actress_name", movie.actressName)
        intent.putExtra("director_name", movie.directorName)
        intent.putExtra("yearOfRelease", movie.yearOfRelease)
        startActivity(intent)
    }
}