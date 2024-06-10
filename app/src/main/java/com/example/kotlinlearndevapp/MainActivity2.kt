package com.example.kotlinlearndevapp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kotlinlearndevapp.Fragments.FragmentB
import com.example.kotlinlearndevapp.Helper.RetrofitHelper
import com.example.kotlinlearndevapp.Interface.QuotesApi
import com.example.kotlinlearndevapp.adapter.MovieAdapter
import com.example.kotlinlearndevapp.databinding.ActivityMain2Binding
import com.example.kotlinlearndevapp.viewModel.MovieViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity2 : AppCompatActivity() {
    lateinit var bindingActivity:ActivityMain2Binding
    lateinit var viewModel: MovieViewModel
    lateinit var movieAdapter: MovieAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingActivity = DataBindingUtil.setContentView(this,R.layout.activity_main2)

       // setContentView(R.layout.activity_main2)
        Toast.makeText(applicationContext,"onCreate2",Toast.LENGTH_SHORT).show()
        var intent = getIntent();
        val str = intent.getStringExtra("name")
       // val key = intent.getIntExtra("key",0)
      // bindingActivity.text2.text = str;
        prepareRecyclerView()
        viewModel = ViewModelProvider(this)[MovieViewModel::class.java]

        val quoteApi = RetrofitHelper.getnstance().create(QuotesApi::class.java)
        GlobalScope.launch {
           /* val result = quoteApi.getQuotes()
            if (result != null){
                Log.d("shilpi", result.body().toString())

            }*/

            viewModel.getPopularMovies();
            /*viewModel.observeMovieLiveData().observe(this, Observer { movieList ->
                movieAdapter.setMovieList(movieList)
            })*/
        }
    }

  private fun prepareRecyclerView(){
      movieAdapter = MovieAdapter()
      bindingActivity.rvMovies.apply {
          layoutManager = GridLayoutManager(applicationContext,2)
          adapter = movieAdapter
      }
  }
    override fun onStart() {
        super.onStart()
        Toast.makeText(applicationContext,"onStart2", Toast.LENGTH_SHORT).show()

    }


    override fun onResume() {
        super.onResume()
        Toast.makeText(applicationContext,"onResume2", Toast.LENGTH_SHORT).show()

    }


    override fun onPause() {
        super.onPause()
        Toast.makeText(applicationContext,"onPause2", Toast.LENGTH_SHORT).show()

    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(applicationContext,"onStop2", Toast.LENGTH_SHORT).show()

    }


    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(applicationContext,"onDestroy2", Toast.LENGTH_SHORT).show()

    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(applicationContext,"onRestart2", Toast.LENGTH_SHORT).show()
    }

}


