package com.skay.imdb.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.skay.imdb.R
import com.skay.imdb.data.model.Movie
import com.skay.imdb.databinding.ActivityMainBinding
import com.skay.imdb.ui.contract.MoviesListener

class MainActivity : AppCompatActivity(), MoviesListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            initView()
        }
    }

    private fun initView() {
        load(MoviesListFragment())
    }

    private fun load(fragment: Fragment) {
        supportFragmentManager.beginTransaction().add(R.id.container, fragment)
            .commit()
    }

    override fun onRowClick(movie: Movie) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, MovieDetailsFragment.getInstance(movie))
            .addToBackStack(MovieDetailsFragment::class.java.name)
            .commitAllowingStateLoss()
    }
}