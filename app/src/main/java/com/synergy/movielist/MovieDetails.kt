package com.synergy.movielist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MovieDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        val movieName: TextView = findViewById(R.id.movie_name)
        val actorName: TextView = findViewById(R.id.actor_name)
        val actressName: TextView = findViewById(R.id.actress_name)
        val directorName: TextView = findViewById(R.id.director_name)
        val year: TextView = findViewById(R.id.year)


        movieName.text = intent.getStringExtra("movie_name")
        actorName.text = intent.getStringExtra("actor_name")
        actressName.text = intent.getStringExtra("actress_name")
        directorName.text = intent.getStringExtra("director_name")
        year.text = intent.getStringExtra("yearOfRelease")

    }
}