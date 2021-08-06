package com.synergy.movielist.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie_table")
class Movie(@ColumnInfo(name = "movie_name") val movieName: String,
            @ColumnInfo(name="actor_name") val actorName: String,
            @ColumnInfo(name="actress_name") val actressName : String,
            @ColumnInfo(name="director_name") val directorName: String,
            @ColumnInfo(name="year_of_release") val yearOfRelease: String) {

    @PrimaryKey(autoGenerate = true) var id: Int = 0
}