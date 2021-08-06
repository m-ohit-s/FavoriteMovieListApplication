package com.synergy.movielist.repository

import androidx.lifecycle.LiveData
import com.synergy.movielist.Database.Movie
import com.synergy.movielist.Database.MovieDao

class MovieRepository(private val movieDao: MovieDao) {

    val allMovies: LiveData<List<Movie>> = movieDao.getAllMovies()

    suspend fun insert(movie: Movie){
        movieDao.insert(movie)
    }

    suspend fun delete(movie: Movie){
        movieDao.delete(movie)
    }
}