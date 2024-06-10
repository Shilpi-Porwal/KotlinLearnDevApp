package com.example.kotlinlearndevapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlinlearndevapp.databinding.MovieLayoutBinding
import model.Moview
import model.ResultSet

class MovieAdapter: RecyclerView.Adapter<MovieAdapter.ViewHolderMovie>() {


    private var movieList = ArrayList<ResultSet>()

    fun setMovieList(movieList: List<ResultSet>){
            this.movieList = movieList as ArrayList<ResultSet>
            notifyDataSetChanged()

        }


    class ViewHolderMovie(val binding: MovieLayoutBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderMovie {
return ViewHolderMovie(MovieLayoutBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int {
return  movieList.size
    }

    override fun onBindViewHolder(holder: ViewHolderMovie, position: Int) {
        Glide.with(holder.itemView)
            .load("https://image.tmdb.org/t/p/w500"+movieList[position].poster_path)
            .into(holder.binding.movieImage)
holder.binding.movieName.text = movieList[position].title
    }
}