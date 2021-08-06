package com.synergy.movielist.Database

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(movie: Movie)

    @Delete
    suspend fun delete(movie: Movie)

    @Query("select * from movie_table order by id ASC")
    fun getAllMovies(): LiveData<List<Movie>>
}