package com.synergy.movielist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.synergy.movielist.Database.Movie
import com.synergy.movielist.viewModel.MovieViewModel

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val movieName : EditText = findViewById(R.id.movieName)
        val directorName : EditText = findViewById(R.id.directorName)
        val actorName : EditText = findViewById(R.id.actorName)
        val actressName : EditText = findViewById(R.id.actressName)
        val yearOfRelease : EditText = findViewById(R.id.yearOfRelease)
        val addButton: Button = findViewById(R.id.addButton)
        val changeActivity: Button = findViewById(R.id.changeActivity)


        addButton.setOnClickListener{
            val movie = movieName.text.toString()
            val actor = actorName.text.toString()
            val actress = actressName.text.toString()
            val director = directorName.text.toString()
            val yearRelease = yearOfRelease.text.toString()

            if(movie.isNotEmpty() && actor.isNotEmpty() && actress.isNotEmpty() && director.isNotEmpty() && yearRelease.isNotEmpty()){
                viewModel.insertMovie(Movie(movie, actor, actress, director, yearRelease))
                Toast.makeText(this, "${movie} information is added to database", Toast.LENGTH_SHORT).show()
            }
        }

        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(MovieViewModel::class.java)
        viewModel.allMovies.observe(this, Observer {

        })

        changeActivity.setOnClickListener{
            val intent = Intent(this,MovieList::class.java)
            startActivity(intent)
        }

    }
}