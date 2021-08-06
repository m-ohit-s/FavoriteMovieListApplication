package com.synergy.movielist.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.synergy.movielist.Database.Movie
import com.synergy.movielist.Database.MovieDatabase
import com.synergy.movielist.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieViewModel(application: Application): AndroidViewModel(application) {
    val allMovies: LiveData<List<Movie>>
    private val repository: MovieRepository

    init {
        val dao = MovieDatabase.getDatabase(application).getMovieDao()
        repository = MovieRepository(dao)
        allMovies = repository.allMovies
    }

    fun deleteMovie(movie: Movie) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(movie)
    }

    fun insertMovie(movie: Movie) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(movie)
    }
}